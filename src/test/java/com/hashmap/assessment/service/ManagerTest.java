package com.hashmap.assessment.service;

import com.hashmap.assessment.model.employee.Info;
import com.hashmap.assessment.model.enums.EmpRole;
import com.hashmap.assessment.model.enums.EmpType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class ManagerTest {
    Manager manager;

    @Before
    public void init(){
        manager = new Manager();
    }

    @Test
    public void EmailTest(){
        Info info = new Info("abc", "ycvgj#", EmpType.PERMANENT, EmpRole.ADMIN);
        Assert.assertEquals("Invalid Email", manager.addEmployee(info, LocalDate.now()));
    }

    @Test
    public void defaultPermanentHolidayTest(){
        Info info = new Info("abc", "y@gmail.com", EmpType.PERMANENT, EmpRole.ADMIN);
        String uid = manager.addEmployee(info, LocalDate.now());
        Assert.assertEquals(25, manager.getEmployeeMap().get(uid).getLeave().getTotalLeaves());
    }

    @Test
    public void defaultProbationHolidayTest(){
        Info info = new Info("abc", "y@gmail.com", EmpType.PROBATION, EmpRole.ADMIN);
        String uid = manager.addEmployee(info, LocalDate.now());
        Assert.assertEquals(0, manager.getEmployeeMap().get(uid).getLeave().getTotalLeaves());
    }


}
