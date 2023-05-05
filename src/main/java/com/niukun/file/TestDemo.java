package com.niukun.file;

import java.io.*;

public class TestDemo {
    public static void main(String[] args) throws IOException {
        String fileName = "E:\\datasets\\movement-speeds-hourly-new-york-2020-1\\movement-speeds-hourly-new-york-2020-1.csv";


        System.out.println(FileUtils.getFirstFewLines(fileName,10));

    }
}
