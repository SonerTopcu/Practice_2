package com.example.MyObjective2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    public String checkTCNumber(String input) {
        int odd = 0;
        int even = 0;
        String result = "Correct TC number";
        Pattern pattern = Pattern.compile("\\d{11}");
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            String[] strArr = input.split("");
            int[] numbers = new int[strArr.length];

            for (int i = 0; i < strArr.length; i++) {
                numbers[i] = Integer.parseInt(strArr[i]);
            }

            if (numbers[0] != 0) {
                for (int i = 0; i <= 8; i++){
                    if (i % 2 == 0){
                        odd += numbers[i];
                    }
                    else {
                        even += numbers[i];
                    }
                }

                if (numbers[9] == (odd * 7 - even) % 10){
                    if ((odd + even + numbers[9]) % 10 != numbers[10]){
                        result = "Wrong TC number, 11th digit is incorrect.";
                    }
                }
                else {
                    result = "Wrong TC number, 10th digit is incorrect.";
                }
            }
            else {
                result = "Wrong TC number, first digit cannot be 0.";
            }
        }
        else {
                result = "Wrong input, please enter 11 digits.";
            }
            return result;
    }
}
