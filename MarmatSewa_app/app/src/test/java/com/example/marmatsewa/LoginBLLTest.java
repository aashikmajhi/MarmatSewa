package com.example.marmatsewa;


import com.example.marmatsewa.Registration.LoginDevelopment.LoginBLL;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class LoginBLLTest {

    @Test
    public void LoginTest(){
        LoginBLL loginBLL=new LoginBLL("nitesh.katwal20@gmail.com","Nit3sh@123");
        boolean res=loginBLL.checkLogin();
       assertEquals(true,res);
    }
}
