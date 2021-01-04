package com.cg.util;

import org.springframework.util.StringUtils;

import java.util.Arrays;

public class StringCalculator {

    public int Add(String numbers) {
        if (StringUtils.hasLength(numbers)) {
            String[] numbersArray = numbers.split(",");
            return Arrays.stream(numbersArray).map(Integer::valueOf).reduce(Integer::sum).get();
        } else {
            return 0;
        }
    }
}
