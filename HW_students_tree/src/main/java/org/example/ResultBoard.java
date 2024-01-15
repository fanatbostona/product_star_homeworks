package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ResultBoard
{
    TreeSet <Student> students = new TreeSet<Student>();

    void addStudent(String name, Float score)
    {
        Student student = new Student(name, score);
        students.add(student);
    }

    void printStudents()
    {
        for (Student st : students)
            System.out.println(st);
    }

    List<String> top3 ()
    {
        List <String> result = new ArrayList<>(3);
        result.add(students.last().name);
        Student second = students.lower(students.last());
        result.add(second.name);
        Student third = students.lower(second);
        result.add(third.name);

        return result;
    }
}

class Student implements Comparable<Student>
{
    String name;
    Float score;

    public Student(String name, Float score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Студент " + this.name + " со средним баллом " + this.score;
    }

    @Override
    public int compareTo(Student o) {
        if (score == o.score)
        {
            return 0;
        }
        if (score > o.score)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
}
