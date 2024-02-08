package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        ResultBoard rb = new ResultBoard();
        rb.addStudent("Ivan", 3.0f);
        rb.addStudent("Maria", 4.0f);
        rb.addStudent("Vlad", 5.0f);
        rb.addStudent("Anton", 4.5f);
        rb.addStudent("Daria", 1.5f);
        rb.addStudent("Vasiliy", 5.0f);
        List<String> result;
        result = rb.top3();
        for (String s : result)
            System.out.println(s);
    }
}