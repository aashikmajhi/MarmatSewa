package com.example.marmatsewa.TDDTesting;

import com.example.marmatsewa.AdminInterface.SeviceDevelopment.Service;
import com.example.marmatsewa.AdminInterface.SeviceDevelopment.ServiceBLL;
import com.example.marmatsewa.Registration.LoginDevelopment.Login;
import com.example.marmatsewa.Registration.LoginDevelopment.LoginBLL;
import com.example.marmatsewa.url.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ServiceBLLTest {

    @Before
    public void setup() {

        LoginBLL loginBLL = new LoginBLL("admin123@gmail.com", "Admin@123");
        boolean res = loginBLL.checkLogin();
        assertEquals(true, res);
    }

    @Test
    public void AddServiceTest() {
        ServiceBLL serviceBLL = new ServiceBLL(new Service("puncture", "abcd.jpg"));
        boolean res = serviceBLL.checkPostService("puncture", "abcd.jpg");
        assertEquals(true,res);


    }

    @Test
    public void GetServiceTest(){
        ServiceBLL serviceBLL=new ServiceBLL();
        List<Service> services=serviceBLL.getServices();
        Assert.assertNotEquals(false,services);
    }

}
