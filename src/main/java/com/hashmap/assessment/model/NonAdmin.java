package com.hashmap.assessment.model;

import java.time.LocalDate;
import java.util.Map;

public class NonAdmin {
    Map<LocalDate, String> holidayMap;

    public NonAdmin(){
        holidayMap = Holiday.getInstance().getHolidayMap();
    }
}
