package com.cg.util;

import org.springframework.util.StringUtils;

import java.util.Arrays;

public class StringCalculator {

    public int add(String numbers) {
        if (StringUtils.hasLength(numbers)) {
            String defaultDelimiter = ",";
            boolean isDefaultDelimiter = true;

            if (numbers.startsWith("//")) {
                defaultDelimiter = numbers.substring(2, 3);
                numbers = numbers.substring(3);
                isDefaultDelimiter = false;
            }

            numbers = numbers.replace(System.lineSeparator(), defaultDelimiter);
            String[] numbersArray = numbers.split(defaultDelimiter);
            if (!isDefaultDelimiter)
                numbersArray[0] = String.valueOf(0);

            return Arrays.stream(numbersArray).map(Integer::valueOf).reduce(Integer::sum).get();
        } else {
            return 0;
        }
    }
}
