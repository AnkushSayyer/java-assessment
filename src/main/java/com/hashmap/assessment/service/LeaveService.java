package com.hashmap.assessment.service;

import com.hashmap.assessment.model.Employee;
import com.hashmap.assessment.model.Holiday;
import com.hashmap.assessment.model.enums.LeaveType;
import com.hashmap.assessment.model.Request;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;

public class LeaveService {
    Map<LocalDate, String> holidayMap;
    private int leaveDays = 0;

    public LeaveService(){
        holidayMap = Holiday.getInstance().getHolidayMap();
    }
    public String applyLeave(String uid, Request request, Map<String, Employee> employeeMap){
        if(!checkAvailableLeaves(employeeMap.get(uid), request))
            return "Not Enough Leaves Available";

        grantLeaves(request, employeeMap.get(uid));
        return "Granted";
    }

    private void grantLeaves(Request request, Employee employee) {
        grantByCategory(request, employee);
    }

    private void grantByCategory(Request request, Employee employee) {
        if (request.getLeaveType().equals(LeaveType.SL)){
            employee.getLeave().setSickLeave(employee.getLeave().getSickLeave()-leaveDays);
        }
        else if(request.getLeaveType().equals(LeaveType.CL)){
            employee.getLeave().setCasualLeave(employee.getLeave().getCasualLeave()-leaveDays);
        }
        else if (request.getLeaveType().equals(LeaveType.PL)){
            employee.getLeave().setPrivilegeLeave(employee.getLeave().getPrivilegeLeave()-leaveDays);
        }
    }

    private boolean checkAvailableLeaves(Employee employee, Request request) {
        calculateLeaveDays(request);
        return checkByCategory(leaveDays, request, employee);
    }

    private boolean checkByCategory(int leaveDays, Request request, Employee employee) {
        if (request.getLeaveType().equals(LeaveType.SL)){
            return checkDays(leaveDays, employee.getLeave().getSickLeave());
        }
        else if(request.getLeaveType().equals(LeaveType.CL)){
            return checkDays(leaveDays, employee.getLeave().getSickLeave());
        }
        else if (request.getLeaveType().equals(LeaveType.PL)){
            return checkDays(leaveDays, employee.getLeave().getSickLeave());
        }
        return false;
    }

    private boolean checkDays(int leaveDays, int remainingLeaveDays) {
        if (remainingLeaveDays - leaveDays >= 0)
            return true;
        return false;
    }

    private int calculateLeaveDays(Request request) {
        LocalDate from = request.getFrom();
        LocalDate to = request.getTo();
        LocalDate tempDate = from.plusDays(1);
        leaveDays = 0;

        while (!tempDate.equals(to)){
            if (!(tempDate.getDayOfWeek()== DayOfWeek.SATURDAY||tempDate.getDayOfWeek()==DayOfWeek.SUNDAY)
                 && !holidayMap.containsKey(tempDate))
                leaveDays++;

            tempDate = tempDate.plusDays(1);
        }
        return leaveDays;
    }
}
