package com.cg.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }

    @Test
    void add_When_TheNumbersIsEmpty_Then_ReturnZero() {
        int result = calculator.add("");
        assertEquals(0, result);
    }

    @Test
    void add_When_TheNumbersIsOne_Then_ReturnOne() {
        int result = calculator.add("1");
        assertEquals(1, result);
    }

    @Test
    void add_When_TheNumbersIsOneAndTwo_Then_ReturnThree() {
        int result = calculator.add("1,2");
        assertEquals(3, result);
    }

    @Test
    void add_Given_NewLinesAsDelimiter_When_TheNumbersContainsNewLinesChar_Then_ReturnSix() {
        int result = calculator.add("1\n2,3");
        assertEquals(6, result);
    }

    @Test
    void add_Given_SemiColonDelimiter_When_TheNumbersContainsDelimiterAndOneAndTwo_Then_ReturnSix() {
        int result = calculator.add("//;\n1;2");
        assertEquals(3, result);
    }
}