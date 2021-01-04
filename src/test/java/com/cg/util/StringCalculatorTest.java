package com.cg.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addWhenNumbersIsEmptyShouldReturnZero() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.Add("");
        assertEquals(0, result);
    }

    @Test
    void addWhenNumbersIsOneShouldReturnOne() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.Add("1");
        assertEquals(1, result);
    }

    @Test
    void addWhenNumbersIsOneAndTwoShouldReturnThree() {
        StringCalculator calculator = new StringCalculator();
        int result = calculator.Add("1,2");
        assertEquals(3, result);
    }
}