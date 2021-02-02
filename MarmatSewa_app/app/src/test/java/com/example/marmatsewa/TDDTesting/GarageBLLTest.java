package com.example.marmatsewa.TDDTesting;

import com.example.marmatsewa.AdminInterface.GarageListDevelopment.GarageBLL;
import com.example.marmatsewa.AdminInterface.SeviceDevelopment.Service;
import com.example.marmatsewa.AdminInterface.SeviceDevelopment.ServiceBLL;
import com.example.marmatsewa.Registration.LoginDevelopment.LoginBLL;
import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GarageBLLTest {

    @Before
    public void setup() {

        LoginBLL loginBLL = new LoginBLL("majhi.aashik123@gmail.com","Aashik@123");
        boolean res = loginBLL.checkLogin();
        assertEquals(true, res);
    }

@Test
public void GetGarageTest(){
    GarageBLL garageBLL=new GarageBLL();
    List<Workshop> workshops=garageBLL.getAllGarageList();
    Assert.assertNotEquals(false,workshops);
}
}
