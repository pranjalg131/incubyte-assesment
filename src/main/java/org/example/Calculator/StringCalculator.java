package org.example.Calculator;

import java.util.Arrays;

public class StringCalculator {

    public int Add(String numbers){

        if(numbers.isEmpty()) return 0;

        String delimiters = "[\n,]";

        return Arrays.stream(numbers.split(delimiters))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
