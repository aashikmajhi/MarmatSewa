package com.example.marmatsewa.TDDTesting;

import com.example.marmatsewa.AdminInterface.SeviceDevelopment.Service;
import com.example.marmatsewa.AdminInterface.SeviceDevelopment.ServiceBLL;
import com.example.marmatsewa.Registration.LoginDevelopment.LoginBLL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AdminServiceBLLTest {
    @Before
    public void setUp() {
        LoginBLL loginBLL = new LoginBLL("aashikmajhi@gmail.com", "Password123");
        boolean res = loginBLL.checkLogin();
        assertEquals(true, res);
    }

    //    @Test
//    public void ServicePostTest(){
//        ServiceBLL serviceBLL=new ServiceBLL(new )
//    }
    @Test
    public void ServiceGetTest() {
        ServiceBLL getServiceBLL = new ServiceBLL();
        List<Service> services = getServiceBLL.getServices();
        Assert.assertNotEquals(false, services);

    }
}
