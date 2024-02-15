package org.example;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{


    public static void main(String[] args) {
        Function<String,Double> stringToLength = s -> {
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(s);
            ArrayList<Integer> numbers = new ArrayList<>();
            while(m.find()) {
                numbers.add(Integer.valueOf(m.group()));
            }
            return Math.sqrt(Math.pow((numbers.get(2)-numbers.get(0)),2) - Math.pow((numbers.get(3)-numbers.get(1)),2));
        };
        try
        {
            Optional <Double> max = new BufferedReader(new FileReader("src/main/java/org/example/lines.txt")).lines()
                    .map(stringToLength)
                    .max(Double::compare);
            System.out.println(max);

        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}

