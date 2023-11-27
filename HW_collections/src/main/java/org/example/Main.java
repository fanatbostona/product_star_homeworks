package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args)
    {
        FirstTask firstTask = new FirstTask();
        HashMap <Integer,String> hash_map = new HashMap<>();
        System.out.println("Первоначальный HashMap:");
        hash_map.put(1, "Первое место");
        hash_map.put(2, "Второе место");
        hash_map.put(3, "Третье место");
        System.out.println(hash_map);
        System.out.println();
        System.out.println("Измененный HashMap:");
        HashMap <String,Integer> new_hash_map = firstTask.SwapKeysValues(hash_map);
        System.out.println(new_hash_map);
        System.out.println("--------------------------------------------");

        SecondTask secondTask = new SecondTask();
        secondTask.ArrayListTime();

        System.out.println("--------------------------------------------");
        ThirdTask thirdTask = new ThirdTask();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
                arrayList.add(i);
        }
        System.out.println("ArrayList до удаления дубликатов: ");
        System.out.println(arrayList);

        ArrayList<Integer> newArrayList = thirdTask.deleteDubles(arrayList);
        System.out.println("ArrayList после удаления дубликатов: ");
        System.out.println(newArrayList);



    }
}