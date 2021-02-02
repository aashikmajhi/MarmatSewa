package com.example.marmatsewa.TDDTesting;

import com.example.marmatsewa.ProfileDevelopment.ProfileBLL;
import com.example.marmatsewa.Registration.LoginDevelopment.LoginBLL;
import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Workshop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GarageProfileBLLTest {
    @Before
    public void setup() {
        LoginBLL loginBLL = new LoginBLL("majhi.aashik123@gmail.com","Aashik@123");
        boolean res = loginBLL.checkLogin();
        assertEquals(true, res);
    }

//    @Test
//    public void GarageProfileGetTest(){
//        ProfileBLL profileBLL=new ProfileBLL("");
//        List<Workshop> workshops=profileBLL.loadGarageProfile();
//        Assert.assertNotEquals(false,workshops);
//    }
}
