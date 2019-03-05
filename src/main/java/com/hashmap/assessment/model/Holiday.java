package com.hashmap.assessment.model;

import java.time.LocalDate;
import java.util.*;

public class Holiday {
    private Map<LocalDate, String> holidayMap;
    private static Holiday holiday;

    private Holiday() {
        holidayMap = new HashMap<>();
    }

    public synchronized static Holiday getInstance() {
        if (holiday == null)
            holiday = new Holiday();
        return holiday;
    }

    public Map getHolidayMap(){
        return holidayMap;
    }
}
