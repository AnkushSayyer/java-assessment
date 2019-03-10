package com.hashmap.assessment.model;

import com.hashmap.assessment.model.employee.Employee;
import lombok.Getter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Getter
public class Database {
    private Map<LocalDate, String> holidayMap;
    private Map<String, Employee> employeeMap;

    public Database(){
        holidayMap = new HashMap<>();
        employeeMap = new HashMap<>();
    }
}
