package com.example.marmatsewa.TDDTesting;

import com.example.marmatsewa.Registration.LoginDevelopment.LoginBLL;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdminGarageBLLTest {

@Before
public void setUp() {
    LoginBLL loginBLL = new LoginBLL("aashikmajhi@gmail.com", "Password123");
    boolean res = loginBLL.checkLogin();
    assertEquals(true, res);
}
@Test
    public void AdminGarageTest(){

}

}
