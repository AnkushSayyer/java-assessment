package com.hashmap.assessment.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
    private static Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
    private static Matcher matcher;

    public static boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}

