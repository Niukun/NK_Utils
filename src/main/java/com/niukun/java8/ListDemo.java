package com.niukun.java8;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * @ClassName ListDemo
 * @Description TODO
 * @Author Administrator
 * @Date 2023/4/28 14:58
 * Version 1.0
 **/
public class ListDemo {
    public static void main(String[] args) throws FileNotFoundException {

        List list = new ArrayList();
        list.add(new Apple(1,"banem"));
        list.add(new Apple(2,"342"));
        list.add(new Apple(6,"sdf"));
        list.add(new Apple(4,"cxv"));
        list.add(new Apple(3,"dgfgh"));
        list.add(new Apple(9,"ghj"));
        list.add(new Apple(8,"hgj"));

        list.sort(comparing(Apple::getSize));

        System.out.println(list);


        InputStream inputStream = new FileInputStream("");
    }
}


class Apple{
    private int size;
    private String type;


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Apple(int size, String type) {
        this.size = size;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "size=" + size +
                ", type='" + type + '\'' +
                '}';
    }
}