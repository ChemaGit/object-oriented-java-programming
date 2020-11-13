package com.week_4;

public class Person implements Comparable<Person>{
    private String name;

    public Person(String name) {
        this.name = name;
        System.out.print("#1 ");
    }

    public boolean isAsleep(int hr)  {
        return 22 < hr || 7 > hr;
    }

    public void status( int hr ) {
        if ( this.isAsleep( hr ) )
            System.out.println( "Now offline: " + this );
        else
            System.out.println( "Now online: " + this );
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public void method1() {
        System.out.print("Person 1 ");
    }
    public void method2() {
        System.out.print("Person 2 ");
    }

    public static void main(String[] args) {
        Student x = new Student();
        Student s = new Student("Chema", 5.2);
        Person p = new Person("Pele");
        Person q = new Person("Maradona");
        Faculty f = new Faculty("Cruyff", 560.3);
        Object o = new Faculty("Beckenbauer", 953.6);
        o = s;
        p = s;
        double m = ((Student)p).getGpa();
        s.getName();
        System.out.println(p);
        System.out.println(s);

        Person ma;
        ma = new Student("Sally", 658.2);
        ma.status(1);

        Person u = new Undergrad();
        u.method1();
    }

    @Override
    public int compareTo(Person person) {
        return this.getName().compareTo(person.getName());
    }
}
