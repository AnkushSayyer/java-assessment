package com.hashmap.assessment.model.employee;

import com.hashmap.assessment.model.enums.EmpRole;
import com.hashmap.assessment.model.enums.LeaveType;
import com.hashmap.assessment.service.HolidayService;

import java.time.LocalDate;
import java.util.Map;

public class Employee {
    private String id;
    private LocalDate dateOfJoining;
    private Info info;
    private Map<LeaveType, Integer> leaveMap;

    HolidayService holidayService;

    public Employee(String id, LocalDate dateOfJoining, Info info) {
        this.id = id;
        this.dateOfJoining = dateOfJoining;
        this.info = info;
        holidayService = new HolidayService();
    }

    public Map<LeaveType, Integer> getLeaveMap() {
        return leaveMap;
    }

    public void setLeaveMap(Map<LeaveType, Integer> leaveMap) {
        this.leaveMap = leaveMap;
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

    public void addHoliday(LocalDate date, String occassion){
        if(this.info.getEmpRole() == EmpRole.ADMIN)
            holidayService.addHoliday(date, occassion);
    }
}
