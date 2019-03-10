package com.hashmap.assessment.service;

import com.hashmap.assessment.model.employee.Info;
import com.hashmap.assessment.model.Request;
import com.hashmap.assessment.model.enums.LeaveType;
import com.hashmap.assessment.model.enums.EmpRole;
import com.hashmap.assessment.model.enums.EmpType;
import com.hashmap.assessment.util.DateFromStringUtil;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LeaveServiceTest {
    LeaveService leaveService;

    @Test
    public void LeaveTestForProbtion(){
        Manager manager = new Manager();
        Info info = new Info("abc", "y@gmail.com", EmpType.PROBATION, EmpRole.ADMIN);
        String uid = manager.addEmployee(info, LocalDate.now());
        leaveService = new LeaveService();
        String result = leaveService.applyLeave(uid, new Request(DateFromStringUtil.getDateFromString("5/3/2019"),
                        DateFromStringUtil.getDateFromString("10/3/2019"), LeaveType.CL)
                        );
        Assert.assertEquals(true, "Not Enough Leaves Available".equals(result));
    }

    @Test
    public void LeaveTestForPeermanent(){
        Manager manager = new Manager();
        Info info = new Info("abc", "y@gmail.com", EmpType.PERMANENT, EmpRole.ADMIN);
        String uid = manager.addEmployee(info, LocalDate.now());
        leaveService = new LeaveService();
        String result = leaveService.applyLeave(uid, new Request(DateFromStringUtil.getDateFromString("5/3/2019"),
                        DateFromStringUtil.getDateFromString("9/3/2019"), LeaveType.CL)
                        );
        Assert.assertEquals(true, "Granted".equals(result));
    }

    @Test
    public void remainingLeaves(){
        Manager manager = new Manager();
        Info info = new Info("abc", "y@gmail.com", EmpType.PERMANENT, EmpRole.ADMIN);
        String uid = manager.addEmployee(info, LocalDate.now());
        leaveService = new LeaveService();
        String result = leaveService.applyLeave(uid, new Request(DateFromStringUtil.getDateFromString("5/3/2019"),
                                DateFromStringUtil.getDateFromString("9/3/2019"), LeaveType.PL)
                            );
        System.out.println(manager.getEmployeeMap().get(uid).getLeaveMap());
        Assert.assertEquals(java.util.Optional.of(0), manager.getEmployeeMap().get(uid).getLeaveMap().get(LeaveType.PL));
    }
}