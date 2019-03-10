package com.hashmap.assessment.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;

public class HolidayService {
    private Map<LocalDate, String> holidayMap;

    public HolidayService(){
        holidayMap = DatabaseService.getInstance().getHolidayMap();
    }

    public void addHoliday(LocalDate date, String occassion){
        holidayMap.put(date, occassion);
    }

    public void getMonthlyHolidays(Month month){
        Map<LocalDate, String> monthlyHolidays = new HashMap<>();
        for (LocalDate date : holidayMap.keySet()){
            if (date.getMonth().equals(month)){
                monthlyHolidays.put(date, holidayMap.get(date));
            }
        }
    }

    public void viewYearlyHolidays(Year year){
        Map<LocalDate, String> yearlyMap = new HashMap<>();
        for (LocalDate date : holidayMap.keySet()) {
            if (year.equals(date.getYear()))
                yearlyMap.put(date, holidayMap.get(date));
        }
    }

    public void viewMonthlyHolidays(){
        Map<Month, Map<LocalDate, String>> monthlyMap = new HashMap<>();
        for (LocalDate date : holidayMap.keySet()) {
            populateByMonth(monthlyMap, date);
        }

    }

    private void populateByMonth(Map<Month, Map<LocalDate, String>> monthlyMap, LocalDate date) {
        for (Month month : Month.values()) {
            monthlyMap.put(month, new HashMap<>());
            if (date.getMonth().equals(month)) {
                monthlyMap.get(month).put(date, holidayMap.get(date));
            }
        }
    }

}
