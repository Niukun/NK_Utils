package com.niukun.serial;

public class Person {
    private int num;
    private int age;

    public Person() {
    }

    public Person(int num, int age) {
        this.num = num;
        this.age = age;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "num=" + num +
                ", age=" + age +
                '}';
    }
}
