package com.example.marmatsewa.User;

import com.example.marmatsewa.ProfileDevelopment.ProfileBLL;
import com.example.marmatsewa.Registration.LoginDevelopment.LoginBLL;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProfileBLLTest {
    @Before
    public void setUp() {
        LoginBLL loginBLL = new LoginBLL("aashikmajhi@gmail.com", "Password123");
        boolean res = loginBLL.checkLogin();
        assertEquals(true, res);
    }

//    @Test
//    public void GetProfileTest() {
//
//        ProfileBLL profileBLL = new ProfileBLL("user_id");
//
//    }

}
