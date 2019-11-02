import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import myCollections.MyCollections;

public class Student implements Comparable<Student> { // Comparable object k sath hi hota hai jo usi class me comparable
                                                      // method i.e compareTo use kr skta hai

    private static class MyComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }

    }

    public static void main(String[] args) {
        Student s = new Student(4, "Nitish", 9.50f);
        List<Student> list = new ArrayList<>();
        list.add(s);
        list.add(new Student(2, "Bunty", 5.9f));
        list.add(new Student(3, "Dhiman", 9.9f));
        list.add(new Student(1, "ND", 1.9f));
        System.out.println("*******Not Sorted**********");
        for (Student d : list) {
            System.out.println(d);
        }

        System.out.println("*******MyCollections Sort**********");
        MyCollections<Student> col = new MyCollections<Student>();
        col.sort(list);
        for (Student d : list) {
            System.out.println(d);
        }

        System.out.println("********Sort On Name*********");
        Collections.sort(list);
        for (Student d : list) {
            System.out.println(d);
        }

        System.out.println("********Comparator*********");
        Collections.sort(list, new MyComparator());
        for (Student d : list) {
            System.out.println(d);
        }

        System.out.println("********CGPA Comparator*********");
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (o1.cgpa - o2.cgpa);
            }
        });
        for (Student d : list) {
            System.out.println(d);
        }
    }

    private int id;
    private String name;
    private float cgpa;

    public Student(int id, String name, float cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return ("Id: " + this.id + " Name: " + this.name + " CGPA: " + this.cgpa);
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}