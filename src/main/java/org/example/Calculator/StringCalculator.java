package org.example.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public int Add(String numbers) throws Exception {

        if(numbers.isEmpty()) return 0;

        String delimiters = "[\n,]";

        if(numbers.startsWith("//")){

            String [] parts = numbers.split("\n");

            delimiters = parts[0];
            numbers = parts[1];

            delimiters = delimiters.replaceFirst("//", "");

            delimiters = "[" + delimiters + "]";

        }

        List<Integer> negatives =  new ArrayList<>();

        int sum =  Arrays.stream(numbers.split(delimiters))
                .mapToInt(Integer::parseInt)
                .map(number -> {
                    if(number < 0){
                        negatives.add(number);
                        return 0;
                    }
                    return number;
                })
                .sum();

        if(!negatives.isEmpty()) throw new Exception("Negatives are not allowed. Please remove the following numbers: " + negatives.toString());

        return sum;
    }
}
