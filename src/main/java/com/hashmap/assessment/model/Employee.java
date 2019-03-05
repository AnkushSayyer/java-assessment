package com.hashmap.assessment.model;

import com.hashmap.assessment.service.HolidayService;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

public class Employee {
    private String id;
    private LocalDate dateOfJoining;
    private Info info;
    Leave leave;
    HolidayService holidayService;

    public Employee(String id, LocalDate dateOfJoining, Info info) {
        this.id = id;
        this.dateOfJoining = dateOfJoining;
        this.info = info;
        holidayService = new HolidayService();
        leave = new Leave(0,0,0);
    }

    public String getId() {
        return id;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public Info getInfo() {
        return info;
    }

    public Leave getLeave(){
        return leave;
    }
}
