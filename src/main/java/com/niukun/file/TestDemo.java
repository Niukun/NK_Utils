package com.niukun.file;

import java.io.*;

public class TestDemo {
    public static void main(String[] args) throws Exception {
        String filename = "E:\\Data\\ML\\jwj\\wechat\\Msg\\OpenIMMsg.db";
        FileInputStream fis = new FileInputStream(filename);
        byte[] bytes = new byte[1024];
        int len = fis.read(bytes);

        while (len != -1) {
            for (byte b: bytes ) {
                System.out.print(b);
            }
            len=fis.read(bytes);
        }

        fis.close();



    }
}
