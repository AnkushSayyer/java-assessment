package com.hashmap.assessment.service;

import com.hashmap.assessment.model.Database;
import com.hashmap.assessment.model.employee.Employee;

import java.time.LocalDate;
import java.util.Map;

public class DatabaseService {
    private static DatabaseService databaseService;
    private Database database;

    private DatabaseService(){
        database = new Database();
    }

    public static DatabaseService getInstance(){
        if(databaseService == null)
            databaseService = new DatabaseService();
        return databaseService;
    }

    public Map<LocalDate, String> getHolidayMap() {
        return database.getHolidayMap();
    }

    public Map<String, Employee> getEmployeeMap(){
        return database.getEmployeeMap();
    }

    public void addEmployee(String id, Employee emp) {
        database.getEmployeeMap().put(id, emp);
    }
}
