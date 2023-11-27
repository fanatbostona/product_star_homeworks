package org.example;

import java.util.ArrayList;
import java.util.HashSet;

public class ThirdTask
{
    //Задание 3: Реализуй метод, который на вход примет ArrayList строк и удаляет из него все дубликаты,
    // не используя метод contains(). Можно использовать другие коллекции, которые были изучены на уроке.

    public ArrayList<Integer> deleteDubles(ArrayList<Integer> e)
    {
        if (e.size() == 0)
        {
            return null;
        }
        else
        {
            HashSet<Integer> newHS = new HashSet<>(e);
            ArrayList<Integer> al = new ArrayList<>(newHS);
            return al;
        }
    }
}
