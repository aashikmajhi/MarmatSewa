package com.example.marmatsewa.TDDTesting;

import com.example.marmatsewa.ProfileDevelopment.ProfileBLL;
import com.example.marmatsewa.Registration.LoginDevelopment.LoginBLL;
import com.example.marmatsewa.Registration.UserRegistrationDevelopment.User;
import com.example.marmatsewa.Registration.UserRegistrationDevelopment.UserRegisterBLL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProfileBLLTest {

    @Before
    public void setup() {
        LoginBLL loginBLL = new LoginBLL("aashikmajhi@gmail.com", "Password123");
        boolean res = loginBLL.checkLogin();
        assertEquals(true, res);
    }

//    @Test
//    public void GetProfileTest() {
//        ProfileBLL profileBLL=new ProfileBLL("");
//        List<User>users=profileBLL.loadProfile();
//        Assert.assertNotEquals(false,users);
//
//    }
}
