package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class SecondTask
{
    public void ArrayListTime()
    {
        // Задание 2: Реализуй метод, в котором создаются ArrayList, LinkedList и заполняются 1 000 000
        // случайными элементами одного и того же типа. После из ArrayList и LinkedList 1000 раз выбираем элемент по случайному индексу.
        // Замерь время для ArrayList и LinkedList. Сравни результаты и предположи, почему они могут отличаться.

        ArrayList al = new ArrayList<Integer>();
        LinkedList <Integer> ll = new LinkedList<>();

        int kol = 1000000;
        for (int i = 0; i < kol; i++)
        {
            al.add((int) (Math.random() * 100000) - 50000);
            ll.add((int) (Math.random() * 100000) - 50000);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0 ; i < 1000; i++)
        {
            int a = al.indexOf((int) (Math.random() * 100000) - 50000);
        }
        long endTime = System.currentTimeMillis();
        long alTimeSearch = endTime - startTime;
        System.out.println("Время поиска в ArrayList = " + (double) alTimeSearch/1000+ " секунд");
        System.out.println();
        long startTime1 = System.currentTimeMillis();
        for (int i = 0 ; i < 1000; i++)
        {
            int a = ll.indexOf((int) (Math.random() * 100000) - 50000);
        }
        long endTime1 = System.currentTimeMillis();
        long llTimeSearch = endTime1 - startTime1;
        System.out.println("Время поиска в LinkedList = " + (double) llTimeSearch/1000+ " секунд");

        // Поиск в ArrayList составляет O(1), а в LinkedList - O(n)
    }
}
