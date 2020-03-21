package com.niukun.file;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFileUtils {
    static final String zipFilePath = "H:\\";
    static final String fileName = "day7.zip";
    public static void main(String[] args) throws IOException {


        unzipFile(zipFilePath + fileName);



    }

    private static void unzipFile(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filePath));
        ZipInputStream zins = new ZipInputStream(fis);
        ZipEntry entry = null;
        while((entry = zins.getNextEntry() )!= null){
            FileOutputStream fos = new FileOutputStream(zipFilePath + "folder");
            byte[] buf = new byte[1024];
            int len = -1;
            while((len = zins.read(buf))!=-1){
                fos.write(buf);
            }
            fos.close();
            zins.closeEntry();
        }
        zins.close();
        fis.close();
    }
}
