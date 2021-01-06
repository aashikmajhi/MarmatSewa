package com.example.marmatsewa;

import com.example.marmatsewa.Registration.UserRegistrationDevelopment.User;
import com.example.marmatsewa.Registration.UserRegistrationDevelopment.UserRegisterBLL;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserRegisterBLLTest {
    @Test
            public void UserRegisterTests(){
        UserRegisterBLL userRegisterBLL=new UserRegisterBLL(new User("AShik Majhi","ashik.majhi20@gmail.com",
                "Ashik123","9861203756","Boudha",
                "1996-12-12","Male","aaaaaa.png"));
        boolean res=userRegisterBLL.isRegisterUser();
        assertEquals(true,res);
    }

}
