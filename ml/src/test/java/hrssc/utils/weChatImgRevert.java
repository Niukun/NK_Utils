package hrssc.utils;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class weChatImgRevert {

    public static void main(String[] args) {
        String path = "E:\\Data\\ML\\jwj\\wechat\\Image\\2021-12 - src\\";
        String targetPath = "E:\\Data\\ML\\jwj\\wechat\\Image\\2021-12 - dest\\";
        int xor = 0xCB;
        convert(path, targetPath, xor);
    }

    /**
     * @param path       图片地址
     * @param targetPath 转换后目录
     */
    private static void convert(String path, String targetPath, int xor) {
        File[] file = new File(path).listFiles();
        if (file == null) {
            return;
        }
        int size = file.length;
        System.out.println("总共" + size + "个文件");
        AtomicReference<Integer> integer = new AtomicReference<>(0);
        Arrays.stream(file).parallel().forEach(file1 -> {
            try (InputStream reader = new FileInputStream(file1);
                 OutputStream writer =
                         new FileOutputStream(targetPath + file1.getName().split("\\.")[0] + ".jpg")) {
                byte[] bytes = new byte[1024 * 10];
                int b;
                while ((b = reader.read(bytes)) != -1) {//这里的in.read(bytes);就是把输入流中的东西，写入到内存中（bytes）。
                    for (int i = 0; i < bytes.length; i++) {
                        bytes[i] = (byte) (int) (bytes[i] ^ xor);
                        if (i == (b - 1)) {
                            break;
                        }
                    }
                    writer.write(bytes, 0, b);
                    writer.flush();
                }
                integer.set(integer.get() + 1);
                System.out.println(file1.getName() + "(大小:" + ((double) file1.length() / 1000) + "kb),进度：" + integer.get() +
                        "/" + size);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println("解析完毕！");
    }

    /**
     * 获取异或值，不一定准确，当解析不出来的时候，换一张图片的异或值来解析
     *
     * @param PhotoPath
     * @return
     */
    private static int getXor(String PhotoPath) {
        File file = new File(PhotoPath);
        try (InputStream reader = new FileInputStream(file)) {
            int[] xors = new int[4];
            xors[0] = reader.read() & 0xFF ^ 0xFF;
            xors[1] = reader.read() & 0xFF ^ 0xD8;
            reader.skip(file.length() - 1);
            xors[2] = reader.read() & 0xFF ^ 0xFF;
            xors[3] = reader.read() & 0xFF ^ 0xD9;
            Map<Integer, Integer> map = new HashMap<>();
            for (int xor : xors) {
                if (map.containsKey(xor)) {
                    map.put(xor, map.get(xor) + 1);
                } else {
                    map.put(xor, 1);
                }
            }
            return map.values().stream().max(Integer::compareTo).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
