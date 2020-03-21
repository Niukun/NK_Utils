package com.niukun.serial;

import java.io.Serializable;

public class Student extends Person implements Serializable {
    private int sid;

    public Student(int name, int age) {
        super(name, age);
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                '}';
    }
}
