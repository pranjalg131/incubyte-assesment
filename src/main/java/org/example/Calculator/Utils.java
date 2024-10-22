package org.example.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static List<Integer> parseInput(String input){

        List<Integer> numbers = new ArrayList<>();

        String regex = "[\n,]";

        if(input.startsWith("//")){

            String [] parts = input.split("\n");

            if(parts.length < 2)
                return numbers;

            String delimiters = parts[0];
            input = parts[1];

            delimiters = delimiters.replaceFirst("//", "");

            if(delimiters.startsWith("[")){
                Pattern pattern = Pattern.compile("\\[(.*?)]");
                Matcher matcher = pattern.matcher(delimiters);

                StringBuilder regexBuilder = new StringBuilder();
                while (matcher.find()) {
                    // Append each delimiter, escaping if necessary
                    String delimiter = matcher.group(1);
                    regexBuilder.append(Pattern.quote(delimiter)).append("|");
                }

                // Remove the last "|"
                if (regexBuilder.length() > 0) {
                    regexBuilder.setLength(regexBuilder.length() - 1); // Remove the last '|'
                }

                regex = regexBuilder.toString();

            } else {
                regex = "[" + delimiters + "]";
            }
        }
        
        Arrays.stream(input.split(regex))
                .mapToInt(Integer::parseInt)
                .forEach(numbers::add);

        return numbers;
    }
}
