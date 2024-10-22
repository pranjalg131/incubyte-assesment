package org.example.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int Add(String input) throws Exception {

        if(input.isEmpty()) return 0;

        List<Integer> numbers = Utils.parseInput(input);
        List<Integer> negatives = new ArrayList<>();

        int sum = 0;

        for(int i = 0; i < numbers.size(); i++){
            int currNum = numbers.get(i);

            // Collect Negative Numbers.
            if(currNum < 0){
                negatives.add(currNum);
            } else if(currNum > 1000){
              continue;
            } else {
                sum += currNum;
            }
        }

        if(!negatives.isEmpty()) throw new Exception("Negatives are not allowed. Please remove the following numbers: " + negatives);

        return sum;
    }
}
