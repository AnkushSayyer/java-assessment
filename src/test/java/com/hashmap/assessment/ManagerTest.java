package com.hashmap.assessment;

import com.hashmap.assessment.model.Employee;
import com.hashmap.assessment.model.Info;
import com.hashmap.assessment.model.Role;
import com.hashmap.assessment.model.Type;
import com.hashmap.assessment.service.Manager;
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
    public void test1(){
        Info info = new Info("abc", "ycvgj#", Type.PERMANENT, Role.ADMIN);
        Assert.assertEquals("Invalid Email", manager.addEmployee(info, LocalDate.now()));


    }

    @Test
    public void test2(){
        Info info = new Info("abc", "y@gmail.com", Type.PERMANENT, Role.ADMIN);
        manager.addEmployee(info, LocalDate.now());
        Assert.assertEquals(25, manager.employeeList().get(manager.employeeList().size()-1).getLeave().getTotalLeaves());
    }

    @Test
    public void test3(){
        Info info = new Info("abc", "y@gmail.com", Type.PROBATION, Role.ADMIN);
        manager.addEmployee(info, LocalDate.now());
        Assert.assertEquals(0, manager.employeeList().get(manager.employeeList().size()-1).getLeave().getTotalLeaves());
    }
}
