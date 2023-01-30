package com.niukun.file;

import java.io.*;

public class TestDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("E:\\datasets\\movement-speeds-hourly-new-york-2020-1\\movement-speeds-hourly-new-york-2020-1.csv"));
        for(int i = 0; i < 10;i++){
            System.out.println(bufferedReader.readLine());
        }

        bufferedReader.close();

    }
}
