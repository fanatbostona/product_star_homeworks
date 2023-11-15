package org.example;

import java.util.Scanner;

public class Calculator
{
    private int operationsCounter = 0; // Счётчик кол-ва операций (<10)
    private double[] operationsResults = new double[10];

    public void Calculating()
    {
        for (int i = 0; i < 10; i++)
        {
            Scanner reader = new Scanner(System.in);
            System.out.print("Введите 2 числа ");
            double first = reader.nextDouble();
            double second = reader.nextDouble();
            System.out.print("Введите оператор: (+, -, *, /): ");
            char operator = reader.next().charAt(0);
            switch (operator) {
                case '+':
                    operationsResults[operationsCounter] = first + second;
                    break;

                case '-':
                    operationsResults[operationsCounter] = first - second;
                    break;

                case '*':
                    operationsResults[operationsCounter] = first * second;
                    break;

                case '/':
                    operationsResults[operationsCounter] = first / second;
                    break;

                default:
                    System.out.printf("Введите корректный оператор");
                    return;
            }
            System.out.printf("%.1f %c %.1f = %.1f\n", first, operator, second, operationsResults[operationsCounter]);
            operationsCounter++;
            System.out.println("Если ваша работа окончена, то напишите слово - выход. Если нет, то любое другое слово :)");
            String exitWord = reader.next();
            if (exitWord.equals("выход"))
                break;
        }
        ShowingResults();
    }

    public void ShowingResults()
    {
        System.out.println("Наш калькулятор сохранил все ваши результаты в количестве " + operationsCounter + "\nКстати, вот они: ");
        for (int i = 0; i < operationsCounter; i++)
        {
            System.out.println(operationsResults[i]);
        }
    }
    }

