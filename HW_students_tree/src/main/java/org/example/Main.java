package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        ResultBoard rb = new ResultBoard();
        rb.addStudent("Ivanov", 4.4F);
        rb.addStudent("Petrov", 3.73F);
        rb.addStudent("Sidorov", 4.41F);
        rb.addStudent("Lebron", 5.0F);
        rb.addStudent("Jordan", 3.54F);
        rb.printStudents();
        List<String> result = new ArrayList<>(3);
        result = rb.top3();
        for (String s : result)
            System.out.println(s);


    }
}