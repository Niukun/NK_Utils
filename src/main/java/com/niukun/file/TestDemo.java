package com.niukun.file;

import java.io.File;
import java.io.IOException;

public class TestDemo {
    public static void main(String[] args) throws InterruptedException {
        String property = System.getProperty("oracle.native.driver");
        if(null == property){
            System.out.println("aaa" + true);
            System.out.println("aaa" + Boolean.TRUE);
        }
        System.out.println(property);

    }
}
