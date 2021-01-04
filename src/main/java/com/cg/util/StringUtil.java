package com.cg.util;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.springframework.util.StringUtils.hasLength;

public class StringUtil {

    public String greeting(String name) {

        if (hasLength(name)) {
            return name.toUpperCase().equals(name) ? "HELLO " + name.toUpperCase() + "!" : "Hello, " + name + ".";
        } else {
            return "Hello, my friend.";
        }
    }

    public String greeting(String[] name) {

        name = commaCleansing(name);
        String upperCase = checkUpperCase(name);
        if (upperCase != null) return upperCase;

        String concatenated;

        if (name != null && name.length > 2) {
            name[name.length - 1] = "and ".concat(name[name.length - 1]);
            concatenated = String.join(", ", name);
        } else {
            concatenated = String.join(" and ", name);
        }
        return "Hello, ".concat(concatenated).concat(".");
    }

    private String[] commaCleansing(String[] name) {
        final String regex = "(\\w+)";
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        List<String> temp = new ArrayList<>();
        Arrays.stream(name).forEach(s -> {
            String[] tempWords = s.split(",");

            for (String tempWord : tempWords) {
                Matcher matcher = pattern.matcher(tempWord.trim());
                if (matcher.find()) {
                    temp.add(matcher.group());
                }
            }
        });

        return temp.toArray(String[]::new);
    }

    private String checkUpperCase(String[] name) {
        Optional<String> upperCase = Arrays.stream(name)
                .filter(word -> word.toUpperCase().equals(word))
                .findAny();

        String concatenated;
        if (upperCase.isPresent() && StringUtils.hasLength(upperCase.get())) {
            List<String> nameList = new ArrayList<>(Arrays.asList(name));
            nameList.remove(upperCase.get());

            concatenated = String.join(" and ", nameList);

            return "Hello, ".concat(concatenated)
                    .concat(". ")
                    .concat("AND HELLO ")
                    .concat(upperCase.get())
                    .concat("!");
        }
        return null;
    }
}
