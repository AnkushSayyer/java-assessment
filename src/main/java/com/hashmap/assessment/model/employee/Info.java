package com.hashmap.assessment.model.employee;

import com.hashmap.assessment.model.enums.EmpRole;
import com.hashmap.assessment.model.enums.EmpType;
import lombok.Getter;

@Getter
public class Info {
    private String name;
    private String email;
    private EmpType empType;
    private EmpRole empRole;

    public void setEmpType(EmpType empType) {
        this.empType = empType;
    }

    public Info(String name, String email, EmpType empType, EmpRole empRole) {
        this.name = name;
        this.email = email;
        this.empType = empType;
        this.empRole = empRole;
    }
}
