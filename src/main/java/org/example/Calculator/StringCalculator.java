package org.example.Calculator;

import java.util.Arrays;

public class StringCalculator {

    public int Add(String numbers){

        if(numbers.isEmpty()) return 0;

        return Arrays.stream(numbers.split(","))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
