package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {
        int[] arr = new int[100000];
        int[] arr1 = new int[100000];
        int[] arr2 = new int[100000];
        int[] arr3 = new int[100000];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = (int) (Math.random() * 10000) - 5000;
            arr1[i] = (int) (Math.random() * 10000) - 5000;
            arr2[i] = (int) (Math.random() * 10000) - 5000;
            arr3[i] = (int) (Math.random() * 10000) - 5000;
        }
        long startTime = System.currentTimeMillis();
        bubbleSort(arr);
        long endTime = System.currentTimeMillis();
        long timeBubbleSort = endTime - startTime;
        System.out.println("Время сортировки пузырьком = " + (double) timeBubbleSort/1000+ " секунд");

        long startTime2 = System.currentTimeMillis();
        insertionSort(arr1);
        long endTime2 = System.currentTimeMillis();
        long timeInsertionSort = endTime2 - startTime2;
        System.out.println("Время сортировки через вставки = " + (double) timeInsertionSort/1000+ " секунд");

        long startTime3 = System.currentTimeMillis();
        selectionSort(arr2);
        long endTime3 = System.currentTimeMillis();
        long timeSelectionSort = endTime3 - startTime3;
        System.out.println("Время сортировки через выбор = " + (double)timeSelectionSort/1000+ " секунд");

        long startTime1 = System.currentTimeMillis();
        Arrays.sort(arr3);
        long endTime1 = System.currentTimeMillis();
        long timeArraySort = endTime1 - startTime1;
        System.out.println("Время сортировки через Array.sort() = " + (double) timeArraySort/1000 + " секунд");


    }

    public static void bubbleSort(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = 1; j < arr.length - i; j++)
            {
                if (arr[j-1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = key;
        }
    }

    public static void selectionSort(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[minElementIndex] > arr[j])
                {
                    minElementIndex = j;
                }
            }

            if (minElementIndex != i)
            {
                int temp = arr[i];
                arr[i] = arr[minElementIndex];
                arr[minElementIndex] = temp;
            }
        }
    }
}