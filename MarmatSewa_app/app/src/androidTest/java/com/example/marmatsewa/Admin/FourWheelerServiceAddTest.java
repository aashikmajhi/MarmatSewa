package com.example.marmatsewa.Admin;

import androidx.test.rule.ActivityTestRule;

import com.example.marmatsewa.AdminInterface.FourWheelerServices;
import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.LoginDevelopment.LoginBLL;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

public class FourWheelerServiceAddTest {

    @Rule

    public ActivityTestRule<FourWheelerServices> fourWheelerService = new ActivityTestRule<>(FourWheelerServices.class);

    @Before
    public void setUp() {

        LoginBLL loginBLL = new LoginBLL("admin123@gmail.com", "Admin@123");
        boolean res = loginBLL.checkLogin();
        assertEquals(true, res);


    }


    @Test
    public void FourWheelServiceAddTest() {
        onView(withId(R.id.edtFourWheelServiceName))
                .perform(typeText("Engine Check"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.btnAddService))
                .perform(click());
    }
}
