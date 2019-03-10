package com.hashmap.assessment.service;

import com.hashmap.assessment.model.employee.Employee;
import com.hashmap.assessment.model.employee.Info;
import com.hashmap.assessment.model.enums.LeaveType;
import com.hashmap.assessment.model.enums.EmpType;
import com.hashmap.assessment.util.EmailValidator;

import java.time.LocalDate;
import java.util.*;

public class Manager {
    private Map<LeaveType, Integer> leaveMap;
    private DatabaseService databaseService;

    public Manager(){
        databaseService = DatabaseService.getInstance();
    }

    public String addEmployee(Info info, LocalDate dateOfJoining){
        if(!checkName(info.getName()))
            return "Check Name";
        if(!EmailValidator.validateEmail(info.getEmail()))
            return "Invalid Email";

        Employee emp = new Employee(generateUid(), dateOfJoining, info);
        databaseService.addEmployee(emp.getId(), emp);
        creditLeaves(emp);
        return emp.getId();
    }

    private void creditLeaves(Employee emp) {
        leaveMap = new HashMap<>();
        if (emp.getInfo().getEmpType().equals(EmpType.PERMANENT)) {
            setPermanentHolidays(emp);
        }
        else
            setProbationHolidays(emp);
    }

    private void setProbationHolidays(Employee emp) {
        for (LeaveType leaveType : LeaveType.values())
            leaveMap.put(leaveType, 0);
        emp.setLeaveMap(leaveMap);
    }

    private void setPermanentHolidays(Employee emp) {
        for (LeaveType leaveType : LeaveType.values())
            leaveMap.put(leaveType, leaveType.getLeaves());
        emp.setLeaveMap(leaveMap);
    }

    private boolean checkName(String name) {
        if (name.length()<=50)
            return true;
        return false;
    }

    private String generateUid(){
        return UUID.randomUUID().toString();
    }

    private void updateType(){
        Map<String, Employee> employeeMap = databaseService.getEmployeeMap();
        for (String employeeId : employeeMap.keySet()){
            Employee employee = employeeMap.get(employeeId);
            LocalDate tempDate = employee.getDateOfJoining().plusMonths(6);
            if (LocalDate.now().isAfter(tempDate))
                employee.getInfo().setEmpType(EmpType.PERMANENT);
        }
    }

}
