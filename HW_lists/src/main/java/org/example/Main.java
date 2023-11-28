package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        FirstTask firstTask = new FirstTask();
        ArrayList<Integer> new_arr = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        int k = 2;
        System.out.println("Значения подмассивов длиной " + k + " , входящих в исходный массив:");
        ArrayList<Double> resultList = new ArrayList<>();
        resultList = firstTask.getRollingAverage(new_arr,k);
        System.out.println(resultList);

    }
}