package com.hashmap.assessment.service;

import com.hashmap.assessment.model.Employee;
import com.hashmap.assessment.model.Info;
import com.hashmap.assessment.model.Type;
import com.hashmap.assessment.service.EmailValidator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Manager {
    private List<Employee> employeeList;
    private final int SICK_LEAVE = 5;
    private final int CASUAL_LEAVE = 5;
    private final int PRIVILEGE_LEAVE = 15;

    public Manager(){
        employeeList = new ArrayList<>();
    }

    public String addEmployee(Info info, LocalDate dateOfJoining){
        if(!checkName(info))
            return "Check Name";
        if(!checkEmail(info))
            return "Invalid Email";

        Employee emp = new Employee(generateUid(), dateOfJoining, info);
        employeeList.add(emp);
        creditLeaves(emp);
        return "added";
    }

    private void creditLeaves(Employee emp) {
        if (emp.getInfo().getType().equals(Type.PERMANENT)) {
            setPermanentHolidays(emp);
        }
        else
            setProbationHolidays(emp);
    }

    private void setProbationHolidays(Employee emp) {
        emp.getLeave().setSickLeave(0);
        emp.getLeave().setCasualLeave(0);
        emp.getLeave().setPrivilegeLeave(0);
    }

    private void setPermanentHolidays(Employee emp) {
        emp.getLeave().setSickLeave(SICK_LEAVE);
        emp.getLeave().setCasualLeave(CASUAL_LEAVE);
        emp.getLeave().setPrivilegeLeave(PRIVILEGE_LEAVE);
    }

    private boolean checkName(Info info) {
        if (info.getName().length()<=50)
            return true;
        return false;
    }

    private boolean checkEmail(Info info) {
        EmailValidator emailValidator = new EmailValidator();
        return emailValidator.validateEmail(info.getEmail());
    }

    private String generateUid(){
        return UUID.randomUUID().toString();
    }

    private void updateType(){
        for (Employee employee : employeeList){
            LocalDate tempDate = employee.getDateOfJoining().plusMonths(6);

            if (LocalDate.now().isAfter(tempDate))
                employee.getInfo().setType(Type.PERMANENT);
        }
    }

    public List<Employee> employeeList(){
        return employeeList;
    }
}
