package com.week_4;

public class Student extends Person{

    private double gpa;

    public Student() {
        this("Student", 56.2);
        System.out.print("#2 ");
    }

    public Student(String name, double gpa) {
        super(name);
        this.gpa = gpa;
        System.out.print("#3 ");
    }
    @Override
    public boolean isAsleep( int hr ) {
        return 2 < hr && 8 > hr;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return this.getName().concat(":").concat(String.valueOf(this.getGpa()));
    }

    public void method1() {
        System.out.print("Student 1 ");
        super.method1();
        method2();
    }
    public void method2() {
        System.out.print("Student 2 ");
    }
}
