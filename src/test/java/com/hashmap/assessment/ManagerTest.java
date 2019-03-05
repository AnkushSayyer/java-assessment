package com.hashmap.assessment;

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
}
