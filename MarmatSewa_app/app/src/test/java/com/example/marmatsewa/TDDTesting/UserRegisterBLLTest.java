package com.example.marmatsewa.TDDTesting;

import com.example.marmatsewa.Registration.UserRegistrationDevelopment.User;
import com.example.marmatsewa.Registration.UserRegistrationDevelopment.UserRegisterBLL;

import org.junit.Test;

import static org.junit.Assert.*;


public class UserRegisterBLLTest {
    @Test
    public void UserRegisterSuccess() {
        UserRegisterBLL userRegisterBLL = new UserRegisterBLL(new User("Aashik Majhi", "aashikmajhi@gmail.com", "Passw0rD123#", "9845612307", "Chabahil-7", "1996-12-12", "MALE", "abc.jpg"));
        boolean success = userRegisterBLL.isRegisterUser();
        assertEquals(true,success);
    }
}