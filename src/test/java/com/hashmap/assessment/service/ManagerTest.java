package com.hashmap.assessment.service;

import com.hashmap.assessment.model.*;
import com.hashmap.assessment.model.enums.LeaveType;
import com.hashmap.assessment.model.enums.Role;
import com.hashmap.assessment.model.enums.Type;
import com.hashmap.assessment.service.LeaveService;
import com.hashmap.assessment.service.Manager;
import com.hashmap.assessment.util.DateFromStringUtil;
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
        Info info = new Info("abc", "ycvgj#", Type.PERMANENT, Role.ADMIN);
        Assert.assertEquals("Invalid Email", manager.addEmployee(info, LocalDate.now()));
    }

    @Test
    public void defaultPermanentHolidayTest(){
        Info info = new Info("abc", "y@gmail.com", Type.PERMANENT, Role.ADMIN);
        String uid = manager.addEmployee(info, LocalDate.now());
        Assert.assertEquals(25, manager.getEmployeeMap().get(uid).getLeave().getTotalLeaves());
    }

    @Test
    public void defaultProbationHolidayTest(){
        Info info = new Info("abc", "y@gmail.com", Type.PROBATION, Role.ADMIN);
        String uid = manager.addEmployee(info, LocalDate.now());
        Assert.assertEquals(0, manager.getEmployeeMap().get(uid).getLeave().getTotalLeaves());
    }


}
