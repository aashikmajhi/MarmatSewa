package com.example.marmatsewa.TDDTesting;

import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;
import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.WorkshopBLL;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WorksShopBLLTest {
    @Test
    public void WorkShopTest(){
        WorkshopBLL workshopBLL = new WorkshopBLL(new Workshop("NewGarageSolution","Nitesh Katuwal","newgarage@garage.com","passmeIN123","Boudha","9874561203","Private","321045678","register.png", "PENDING",27.7179392,85.3446312,"BOTH"));
        boolean result = workshopBLL.isRegisterWorkshop();
        assertEquals(true,result);
    }
}
