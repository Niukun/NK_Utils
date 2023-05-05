package com.niukun.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static void main(String[] args) throws UnsupportedEncodingException, Exception {
//		FileSplitByLine("D:/NLPIR/sougou/news_sohusite_xml.dat", 6 * 2048*10);
//		System.out.println(FilesBeginsWithCertainString("D:/NLPIR/sougou/news_sohusite_xml/","<doc>"));
//		System.out.println(FilesBeginsWithCertainString("D:/NLPIR/sougou/news_tensite_xml/","<doc>"));
        List allFileNameInFolder = getAllFileNameInFolder("H:\\StudyTemp\\struts2框架2016版视频\\day04视频", false);
        for (Object name : allFileNameInFolder) {
            System.out.println(name);
        }
        String property = System.getProperty("java.ext.dirs");
        property = System.getProperty("java.class.path");
//		System.out.println(property);
    }

    /**
     * 获取指定文本的前几行字符串
     *
     * @param fileName 文件路径
     * @param lines 需要获取的行数
     * @return
     */
    public static List<String> getFirstFewLines(String fileName, int lines) {
        List<String> result = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = null;
            for (int i = 0; i < lines; i++) {
                try {
                    if ((line = bufferedReader.readLine()) != null) {
                        result.add(line);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return result;
        }
    }

    /**
     * 这个方法用来读取文本文件中所有的行数，存到一个list中，然后返回list
     *
     * @param path
     * @return
     */
    public static List<String> getAllLinesFromFile(String path) {
        List list = new ArrayList();
        BufferedReader bufr = null;
        try {
            bufr = new BufferedReader(new FileReader(path));
            String line = null;
            while ((line = bufr.readLine()) != null) {
                list.add(line);
            }
            bufr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufr != null) {
                try {
                    bufr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return list;
        }
    }

    /**
     * 获取指定目录下（非递归）所有文件或者文件夹名称，结果以list存储并返回
     * 默认保留后缀
     *
     * @param filePath
     */
    public static List<String> getAllFileNameInFolder(String filePath) {
        return getAllFileNameInFolder(filePath, true);
    }

    public static List getAllFileNameInFolder(String filePath, boolean keepPostfix) {
        List allFile = new ArrayList();
        File folder = new File(filePath);
        File[] files = folder.listFiles();
        for (File file : files) {
            if (keepPostfix) {
                allFile.add(file.getName());
            } else {
                allFile.add(file.getName().substring(0, file.getName().lastIndexOf(".")));
            }

        }
        return allFile;
    }


    /**
     * 判断一个文件夹目录下所有非目录文件是否以某一个字符串开头
     * 2016-12-20
     *
     * @param path 文件集所在文件
     * @param str  目标字符串
     * @return
     * @throws IOException
     */
    private static boolean FilesBeginsWithCertainString(String path, String str) throws IOException {
        boolean flag = true;
        File file = new File(path);
        File[] files = file.listFiles();
        BufferedReader bufr;
        for (int i = 0; i < files.length; i++) {
            if (!files[i].isDirectory()) {
                bufr = new BufferedReader(new FileReader(files[i]));
                if (!str.equals(bufr.readLine())) {
                    flag = false;
                }
            }
            System.out.println(i + " " + flag);
        }

        return flag;
    }

    /**
     * 已知一个文件，固定抽出来每个文件的行数（fileSize行）作为一个新的文件保存，剩下的存入一个单独的文件
     * 2016-12-20
     *
     * @param string
     * @param fileSize
     * @throws IOException todo 待优化
     */
    private static void FileSplitByLine(String string, int fileSize) throws IOException {
        InputStreamReader isr = new InputStreamReader(
                new FileInputStream(string), "gbk");
        BufferedReader bufr = new BufferedReader(isr);
        int num = 0;
        String str = null;
        while ((str = bufr.readLine()) != null) {
            num++;
        }
        System.out.println(num);
        int filenum = num / fileSize;

        BufferedReader bufrtTwo = new BufferedReader(new InputStreamReader(
                new FileInputStream(string), "gbk"));
        int count = 1;
        for (int i = 1; i <= filenum - 1; i++) {
            BufferedWriter bufw = new BufferedWriter(
                    new FileWriter("D:/NLPIR/sougou/news_sohusite_xml/" + (i) + ".txt"));
            while (((count++) <= fileSize * (i + 1))) {
                if ((str = bufrtTwo.readLine()) != null) {
                    bufw.write(str);
                    bufw.newLine();
                }
            }
            bufw.flush();
            if (bufw != null) {
                bufw.close();
            }
            count--;
            System.out.println(i + 1 + "\tfile finished");
        }
        BufferedWriter bufw = new BufferedWriter(
                new FileWriter("D:/NLPIR/sougou/news_sohusite_xml/" + filenum + ".txt"));
        while ((str = bufrtTwo.readLine()) != null) {
            bufw.write(str);
            bufw.newLine();
        }
        bufw.flush();
        if (bufw != null) {
            bufw.close();
        }
        System.out.println(filenum + "\tfile finished");

    }

    /**
     * 按文件数分解大文件
     * 2016-12-20
     *
     * @param fileNumb
     * @throws UnsupportedEncodingException
     * @throws Exception
     */
    private static void FileSplitByFilenum(int fileNumb) throws UnsupportedEncodingException, Exception {
        InputStreamReader isr = new InputStreamReader(
                new FileInputStream("src/main/resources/testfiles/news_sohusite_xml.dat"), "gbk");
        BufferedReader bufr = new BufferedReader(isr);
        int num = 0;
        String str = null;
        while ((str = bufr.readLine()) != null) {
            num++;
        }
        System.out.println(num);
        int singlefilenum = num / fileNumb;
        BufferedReader bufrtem = new BufferedReader(new InputStreamReader(
                new FileInputStream("src/main/resources/testfiles/news_sohusite_xml.dat"), "gbk"));
        int count = 0;
        for (int i = 0; i < fileNumb - 1; i++) {
            BufferedWriter bufw = new BufferedWriter(
                    new FileWriter("src/main/resources/testfiles/news_sohusite_xml/" + (i + 1) + ".txt"));
            while ((str = bufrtem.readLine()) != null && ((count++) < singlefilenum * (i + 1))) {
                bufw.write(str);
            }
            bufw.flush();
            if (bufw != null) {
                bufw.close();
            }
            System.out.println(i + 1 + "\tfile finished");
        }
        BufferedWriter bufw = new BufferedWriter(
                new FileWriter("src/main/resources/testfiles/news/" + fileNumb + ".txt"));
        while ((str = bufrtem.readLine()) != null) {
            bufw.write(str);
        }
        bufw.flush();
        if (bufw != null) {
            bufw.close();
        }
        System.out.println(fileNumb + "\tfile finished");
    }


    /**
     * 得到一个文件的二进制数字形式
     * 2016-12-19
     *
     * @param filename
     * @param destfile
     * @throws Exception
     */
    public static void getFilesBinary(String filename, String destfile) throws Exception {
        FileInputStream fis = new FileInputStream(filename);
        InputStreamReader isr = new InputStreamReader(fis);

        BufferedReader bufr = new BufferedReader(isr);
        BufferedWriter bufw = new BufferedWriter(new FileWriter(new File(destfile)));

        String str = null;
        while ((str = bufr.readLine()) != null) {
            bufw.write(getStringFromBytes(str.getBytes()));
            bufw.newLine();
            bufw.flush();
        }

        System.out.println("Finished ...");
    }

    public static String getStringFromBytes(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toBinaryString(bytes[i]));
        }
        return sb.toString();
    }

}
