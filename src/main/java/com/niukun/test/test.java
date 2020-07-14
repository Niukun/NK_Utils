package com.niukun.test;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Test {
    private static ResourceBundle rb = ResourceBundle.getBundle("bean");

    public static void main(String[] args) {
        String name = rb.getString("name");
        System.out.println(name);
    }
}

