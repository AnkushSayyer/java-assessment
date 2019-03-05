package com.hashmap.assessment.service;

import com.hashmap.assessment.model.Info;
import com.hashmap.assessment.model.Request;
import com.hashmap.assessment.model.enums.LeaveType;
import com.hashmap.assessment.model.enums.Role;
import com.hashmap.assessment.model.enums.Type;
import com.hashmap.assessment.util.DateFromStringUtil;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class LeaveServiceTest {
    LeaveService leaveService;

    @Test
    public void LeaveTestForProbtion(){
        Manager manager = new Manager();
        Info info = new Info("abc", "y@gmail.com", Type.PROBATION, Role.ADMIN);
        String uid = manager.addEmployee(info, LocalDate.now());
        leaveService = new LeaveService();
        String result = leaveService.applyLeave(uid, new Request(DateFromStringUtil.getDateFromString("5/3/2019"),
                        DateFromStringUtil.getDateFromString("10/3/2019"), LeaveType.CL),
                manager.getEmployeeMap()
        );
        Assert.assertEquals(true, "Not Enough Leaves Available".equals(result));
    }

    @Test
    public void LeaveTestForPeermanent(){
        Manager manager = new Manager();
        Info info = new Info("abc", "y@gmail.com", Type.PERMANENT, Role.ADMIN);
        String uid = manager.addEmployee(info, LocalDate.now());
        leaveService = new LeaveService();
        String result = leaveService.applyLeave(uid, new Request(DateFromStringUtil.getDateFromString("5/3/2019"),
                        DateFromStringUtil.getDateFromString("9/3/2019"), LeaveType.CL),
                manager.getEmployeeMap()
        );
        Assert.assertEquals(true, "Granted".equals(result));
    }
}