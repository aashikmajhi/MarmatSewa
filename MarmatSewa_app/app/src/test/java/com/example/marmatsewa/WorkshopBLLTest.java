package com.example.marmatsewa;


import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;
import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.WorkshopBLL;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WorkshopBLLTest {
    @Test
    public void WorkshopTest(){
        WorkshopBLL workshopBLL=new WorkshopBLL(new Workshop("Aashik Reparing Shop","Ashik Majhi","majhiashil@gmail.com",
                "Aashik1234","Boudha Opposite of Hyatt Regency Hotel ","9861203755",
                "Pan","pan.png","123456789",true,true,true,true));
        boolean res=workshopBLL.isRegisterWorkshop();
        assertEquals(true,res);
    }
}
