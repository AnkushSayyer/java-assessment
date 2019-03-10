package com.hashmap.assessment.service;

import com.hashmap.assessment.model.employee.Employee;
import com.hashmap.assessment.model.enums.LeaveType;
import com.hashmap.assessment.model.Request;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;

public class LeaveService {
    private Map<LocalDate, String> holidayMap;
    private Map<String, Employee> employeeMap;
    private int leaveDays = 0;

    public LeaveService(){
        holidayMap = DatabaseService.getInstance().getHolidayMap();
        employeeMap = DatabaseService.getInstance().getEmployeeMap();
    }
    public String applyLeave(String uid, Request request){
        if(!checkAvailableLeaves(employeeMap.get(uid), request))
            return "Not Enough Leaves Available";

        grantLeaves(request.getLeaveType(), employeeMap.get(uid).getLeaveMap());
        return "Granted";
    }

    private void grantLeaves(LeaveType leaveType, Map<LeaveType, Integer> empLeaveMap) {
        empLeaveMap.put(leaveType,empLeaveMap.get(leaveType)-leaveDays);
    }

    private boolean checkAvailableLeaves(Employee employee, Request request) {
        calculateLeaveDays(request);
        return employee.getLeaveMap().get(request.getLeaveType()) >= leaveDays;
    }

    private int calculateLeaveDays(Request request) {
        LocalDate from = request.getFrom();
        LocalDate to = request.getTo();
        LocalDate tempDate = from;

        while (!tempDate.equals(to)){
            incrementLeaveDays(tempDate);
            tempDate = tempDate.plusDays(1);
        }
        return leaveDays++;
    }

    private void incrementLeaveDays(LocalDate tempDate) {
        if (!(tempDate.getDayOfWeek()== DayOfWeek.SATURDAY||tempDate.getDayOfWeek()==DayOfWeek.SUNDAY)
             && !holidayMap.containsKey(tempDate)
            )
            leaveDays++;
    }
}
