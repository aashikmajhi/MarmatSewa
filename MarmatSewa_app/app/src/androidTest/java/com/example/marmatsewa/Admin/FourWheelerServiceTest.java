package com.example.marmatsewa.Admin;

import androidx.test.rule.ActivityTestRule;

import com.example.marmatsewa.AdminInterface.admin_services;
import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.LoginDevelopment.LoginBLL;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

public class FourWheelerServiceTest {
    @Rule
    public ActivityTestRule<admin_services> testRule=new ActivityTestRule<>(admin_services.class);

    @Before
    public void setUp() {
        LoginBLL loginBLL = new LoginBLL("admin123@gmail.com", "Admin@123");
        boolean res = loginBLL.checkLogin();
        assertEquals(true, res);
    }
    @Test
    public void FourWheelerService() {
        onView(withId(R.id.btnFourWheeler))
                .perform(click());

    }
}
