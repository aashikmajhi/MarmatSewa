package com.example.marmatsewa.TDDTesting;

import com.example.marmatsewa.Registration.LoginDevelopment.LoginBLL;
import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.AddFeaturesBLL;
import com.example.marmatsewa.Registration.WorkshopRegistrationDevelopment.Features;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddFeaturesBLLTest {
    @Before
    public void setup() {

        LoginBLL loginBLL = new LoginBLL("majhi.aashik123@gmail.com", "Aashik@123");
        boolean res = loginBLL.checkLogin();
        assertEquals(true, res);
    }

    @Test
    public void AddFeatureTest() {
        AddFeaturesBLL addFeaturesBLL = new AddFeaturesBLL(new Features("", ""));
        boolean res = addFeaturesBLL.checkAddGarageFeatures();
        assertEquals(true, res);
    }
}
