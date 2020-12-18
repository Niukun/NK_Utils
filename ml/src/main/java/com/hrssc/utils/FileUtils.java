package com.hrssc.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static com.hrssc.utils.ArrayUtils.smartPrint;


public class FileUtils {

    public static void removeFileSuffix(String path){
        File filePath = new File(path);
        if(filePath.isDirectory()){
            File[] files = filePath.listFiles();
            String name;
            for ( File file: files) {
                name = file.getName();
                file.renameTo(new File(path + "\\"+name.substring(0, name.lastIndexOf('.'))));
            }

        }else{
            System.out.println("输入的不是文件路径！");
        }

    }

    /**
     * 把文件中行排序
     * @param filePath
     */
    public static void sortFileLines(String filePath) {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader bufr = null;
        BufferedWriter bufw = null;
        readFromFile(filePath, list, bufr);
        saveToFile(filePath, list, bufw);
    }


    /**
     * 级联解密当前文件夹下面的文件
     * @param srcFilePath
     * @param distFilePath
     * @throws Exception
     */
    public static void cascadeDecodeFiles(String srcFilePath, String distFilePath) throws Exception {
        File file = new File(srcFilePath);
        File[] files = file.listFiles();
        for (File f: files) {
            if(f.isFile()){
                decodeFile(f.getAbsolutePath(),distFilePath +f.getName());
            }else {
                String newPath = distFilePath + f.getName() + "\\";
                File newPathFile = new File(newPath);
                if(!newPathFile.exists()){
                    newPathFile.mkdirs();
                }
                cascadeDecodeFiles(f.getAbsolutePath(),newPath);
            }
        }
    }

    /**
     * 批量解密当前目录文件（非级联）
     * @param path
     */
    public static void decodeAllFilesInFolder(String path){
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f: files ) {
            if(f.isFile()){
                String fileName = f.getAbsolutePath();
                String newFileName = fileName.substring(0, fileName.lastIndexOf(".")) + "【DE】" + fileName.substring(fileName.lastIndexOf("."));
                try {
                    decodeFile(fileName, newFileName);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }


    /**
     * 解密单个文件
     * @param srcFilePath
     * @param distFilePath
     * @throws Exception
     */
    public static void decodeFile(String srcFilePath, String distFilePath) throws Exception {
        FileInputStream fis = new FileInputStream(srcFilePath);
        FileOutputStream fos = new FileOutputStream(distFilePath);
        byte[] bytes = new byte[1024];
        int len = fis.read(bytes);

        while (len != -1) {
            fos.write(bytes, 0, len);
            fos.flush();
            len=fis.read(bytes);
        }
        fos.close();
        fis.close();

        System.out.println(srcFilePath + " decode success!");
        System.out.println("File located at： " + distFilePath + "\n");
    }


    //读取json文件
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject getJSONObjectFromFile(String filePath) {
        return JSON.parseObject(readJsonFile(filePath));
    }

    public static JSONArray getJSONArrayFromFile(String filePath) {
        return JSON.parseArray(readJsonFile(filePath));
    }

    public static List getLinesFromFile(String path){
        List<String> list = new ArrayList<String>();
        try {
            BufferedReader bufr = new BufferedReader(new FileReader(path));
            String line = null;
            while((line = bufr.readLine())!=null){
                list.add(line);
            }
            bufr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  list;

    }




    private static void saveToFile(String filePath, ArrayList<String> list, BufferedWriter bufw) {
        try {
            bufw = new BufferedWriter(new FileWriter(filePath));

            Iterator<String> iterator = list.iterator();

            while (iterator.hasNext()){
                bufw.write(iterator.next());
                bufw.newLine();
                bufw.flush();
            }
            bufw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bufw != null){
                    bufw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void readFromFile(String filePath, ArrayList<String> list, BufferedReader bufr) {
        try {
            bufr = new BufferedReader(new FileReader(filePath));
            String line = null;
            while ((line = bufr.readLine())!=null){
                list.add(line);
            }
            bufr.close();
            Collections.sort(list);
            smartPrint(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bufr != null){
                    bufr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
