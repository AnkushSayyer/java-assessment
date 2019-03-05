package com.hashmap.assessment.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFromStringUtil {

    public static LocalDate getDateFromString(String dateString) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");


        LocalDate localDate = LocalDate.parse(dateString, formatter);
            return localDate;

    }

}
