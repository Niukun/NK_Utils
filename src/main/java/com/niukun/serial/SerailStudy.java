package com.niukun.serial;

import java.io.*;

public class SerailStudy {
    public static void main(String[] args) throws Exception {
//        SerializePerson();
//        System.out.println("Done...");


        DeserializePerson();
        System.out.println("Done...");


    }

    private static void DeserializePerson() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"));
        Student p = (Student) ois.readObject();
        p.setSid(123);
        System.out.println("Student is: " + p);
    }

    private static void SerializePerson() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
        Student s = new Student(11, 11);
        oos.writeObject(s);
    }
}
