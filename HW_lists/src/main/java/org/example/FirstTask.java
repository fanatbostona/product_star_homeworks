package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FirstTask
{
    //Дан непустой массив целых чисел длиной n и число k (0 < k <= n).
    //Нужно вывести среднее значение для всех подмассивов длиной k, входящих в исходный массив.

    public ArrayList<Double> getRollingAverage(ArrayList<Integer> arr, int k) {
        LinkedList<Integer> subList = new LinkedList<>();
        ArrayList<Double> resultList = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < k; i++) {
            subList.add(arr.get(i));
        }
        for (int element : subList)
        {
            sum += element;
        }
        resultList.add((double) sum/k);

        for (int i = k; i < arr.size(); i++)
        {
            sum = 0;
            subList.add(arr.get(i));
            subList.remove();
            for (int element : subList)
            {
                sum += element;
            }
            resultList.add((double) sum/k);
        }

        return resultList;
    }
}
