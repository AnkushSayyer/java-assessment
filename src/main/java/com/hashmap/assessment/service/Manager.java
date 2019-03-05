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
        return "added";
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
}
