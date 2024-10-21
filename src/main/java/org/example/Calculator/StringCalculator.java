package org.example.Calculator;

import java.util.Arrays;

public class StringCalculator {

    public int Add(String numbers){

        if(numbers.isEmpty()) return 0;

        String delimiters = "[\n,]";

        if(numbers.startsWith("//")){

            String [] parts = numbers.split("\n");

            delimiters = parts[0];
            numbers = parts[1];

            delimiters = delimiters.replaceAll("//+", "");

            delimiters = "[" + delimiters + "]";

        }

        return Arrays.stream(numbers.split(delimiters))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
