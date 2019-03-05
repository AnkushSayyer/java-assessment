package com.hashmap.assessment.model;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class Employee {
    private String id;
    private LocalDate dateOfJoining;
    private Info info;

    public String getId() {
        return id;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public Info getInfo() {
        return info;
    }
}
