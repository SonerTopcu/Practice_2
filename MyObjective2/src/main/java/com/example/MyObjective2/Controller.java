package com.example.MyObjective2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Controller {
    public String checkTCNumber(String input) {
        String result = "Correct TC number";
        Pattern pattern = Pattern.compile("\\d{11}");
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            String[] strArr = input.split("");
            int[] number = new int[strArr.length];
            int[] odd = new int[5];
            int[] even = new int[5];
            int oddCount = 0;
            int evenCount = 0;

            for (int i = 0; i < strArr.length; i++) {
                number[i] = Integer.parseInt(strArr[i]);
            }

            if (number[0] != 0){
                for(int i = 0; i <= 8; i++){
                    if(i % 2 == 0){
                        odd[oddCount] = number[i];
                        oddCount++;
                    }
                    else {
                        even[evenCount] = number[i];
                        evenCount++;
                    }
                }

                if (number[9] == (Arrays.stream(odd).sum() * 7 - Arrays.stream(even).sum()) % 10){
                    if (number[10] != (Arrays.stream(number).sum() - number[10]) % 10){
                        result = "Wrong TC number, 11th digit is incorrect.";
                    }
                }
                else {
                    result = "Wrong TC number, 10th digit is incorrect.";
                }
            }
            else{
                result = "Wrong TC number, first digit cannot be 0.";
            }
        }
        else{
            result = "Wrong input, please enter 11 digits.";
        }
        return result;
    }
}