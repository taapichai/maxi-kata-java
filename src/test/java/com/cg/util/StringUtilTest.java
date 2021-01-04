package com.cg.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void greetingWhenNameIsBobShouldReturnBob() {
        StringUtil stringUtil = new StringUtil();
        String name = "Bob";
        String result = stringUtil.greeting(name);
        assertEquals("Hello, Bob.", result);
    }

    @Test
    void greetingWhenNameIsNullShouldReturnMyFriend() {
        StringUtil stringUtil = new StringUtil();
        String result = stringUtil.greeting((String) null);
        assertEquals("Hello, my friend.", result);
    }

    @Test
    void greetingWhenNameIsAllUppercaseShouldReturnShoutingBack() {
        StringUtil stringUtil = new StringUtil();
        String name = "JERRY";
        String result = stringUtil.greeting(name);
        assertEquals("HELLO JERRY!", result);
    }

    @Test
    void greetingWhenNameIsArrayOfTwoNamesShouldReturnBothNames() {
        StringUtil stringUtil = new StringUtil();
        String[] name = {"Jill", "Jane"};
        String result = stringUtil.greeting(name);
        assertEquals("Hello, Jill and Jane.", result);
    }

    @Test
    void greetingWhenNameIsArrayOfMoreThanTwoNamesShouldReturnAllNamesWithCommasAndOxfordComma() {
        StringUtil stringUtil = new StringUtil();
        String[] name = {"Amy", "Brian", "Charlotte"};
        String result = stringUtil.greeting(name);
        assertEquals("Hello, Amy, Brian, and Charlotte.", result);
    }

    @Test
    void greetingWhenNameIsMixingShoutedShouldReturnAllNamesWithShoutedWord() {
        StringUtil stringUtil = new StringUtil();
        String[] name = {"Amy", "BRIAN", "Charlotte"};
        String result = stringUtil.greeting(name);
        assertEquals("Hello, Amy and Charlotte. AND HELLO BRIAN!", result);
    }

    @Test
    void greetingWhenNameContainingCommaShouldReturnAllNamesWithCommasAndOxfordComma() {
        StringUtil stringUtil = new StringUtil();
        String[] name = {"Bob", "Charlie, Dianne"};
        String result = stringUtil.greeting(name);
        assertEquals("Hello, Bob, Charlie, and Dianne.", result);
    }

    @Test
    void greetingWhenNameContainingEscapedDoubleQuoteShouldReturnAllNamesWithCommasAndOxfordComma() {
        StringUtil stringUtil = new StringUtil();
        String[] name = {"Bob", "\"Charlie, Dianne\""};
        String result = stringUtil.greeting(name);
        assertEquals("Hello, Bob, Charlie, and Dianne.", result);
    }

}