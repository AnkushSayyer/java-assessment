package com.hashmap.assessment.model;

import com.hashmap.assessment.model.enums.LeaveType;

import java.time.LocalDate;

public class Request {
    private LocalDate from;
    private LocalDate to;
    private LeaveType leaveType;

    public Request(LocalDate from, LocalDate to, LeaveType leaveType) {
        this.from = from;
        this.to = to;
        this.leaveType = leaveType;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }
}
