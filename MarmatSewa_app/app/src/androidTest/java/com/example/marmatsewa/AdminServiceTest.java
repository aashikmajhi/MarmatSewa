package com.example.marmatsewa;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;


import com.example.marmatsewa.AdminInterface.admin_services;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class AdminServiceTest {
    @Rule
    public ActivityTestRule<admin_services> testRule=new ActivityTestRule<>(admin_services.class);
    @Test
    public void LoginTest() {
        onView(withId(R.id.btnTwoWheeler))
                .perform(click());

        onView(withId(R.id.btnFourWheeler))
                .perform(click());

    }
}
