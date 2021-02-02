package com.example.marmatsewa.TDDTesting;

import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;
import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.WorkshopBLL;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WorksShopBLLTest {
    @Test
    public void WorkShopTest() {
        WorkshopBLL workshopBLL = new WorkshopBLL(new Workshop("Aashik Motorcycle Workshop Reparing Service",
                "Aashik Majhi","majhi.aashik123@gmail.com","Aashik@123","Boudha",
                "9874561230","PAN","987456123","Two Wheeler"));
        boolean success = workshopBLL.isRegisterWorkshop();
        assertEquals(true, success);
    }
}
