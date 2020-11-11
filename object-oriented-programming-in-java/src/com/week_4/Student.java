package com.week_4;

public class Student extends Person{

    private double gpa;

    public Student(String name, double gpa) {
        super(name);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }
}
