package com.hashmap.assessment.service;

import com.hashmap.assessment.model.Holiday;

import java.time.LocalDate;

public class AdminService {
    Holiday holiday;

    public void addHoliday(LocalDate date, String occassion){
        holiday = Holiday.getInstance();
        holiday.getHolidayMap().put(date, occassion);
    }
}
