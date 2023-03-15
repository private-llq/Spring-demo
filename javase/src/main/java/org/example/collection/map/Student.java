package org.example.collection.map;
/**
 * @author llq
 */

public class Student implements Comparable<Student> {
    private int age;
    private String name;
    private double height;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Student() {
    }

    public Student(int age, String name, double height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", height=" + height +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        /*return this.getAge()-o.getAge();*/
        return this.getName().compareTo(o.getName());
    }
}