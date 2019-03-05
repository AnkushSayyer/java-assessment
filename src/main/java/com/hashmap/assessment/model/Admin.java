package com.hashmap.assessment.model;

import java.time.LocalDate;
import java.util.Map;

public class Admin {
    Map<LocalDate, String> holidayMap;

    public Admin(){
        holidayMap = Holiday.getInstance().getHolidayMap();
    }
}
