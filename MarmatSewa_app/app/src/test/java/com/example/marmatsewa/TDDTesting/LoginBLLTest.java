package com.example.marmatsewa.TDDTesting;


import com.example.marmatsewa.Registration.LoginDevelopment.LoginBLL;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class LoginBLLTest {

    @Test
    public void LoginTest() {
        LoginBLL loginBLL = new LoginBLL("aashikmajhi@gmail.com", "Password123");
        boolean res = loginBLL.checkLogin();
        assertEquals(true, res);
    }

}
