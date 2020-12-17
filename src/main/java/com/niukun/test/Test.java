package com.niukun.test;
import java.io.*;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("a.bin"));


        Person person = new Person("niukun",28);
        objectOutputStream.writeObject(person);

        objectOutputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("a.bin"));
        Person o = (Person) inputStream.readObject();
        System.out.println(o);


    }
}

class Person implements Serializable{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

