package com.example.marmatsewa.Admin;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import com.example.marmatsewa.AdminInterface.FourWheelerServices;
import com.example.marmatsewa.R;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class FourWheelerServiceTest {

    @Rule
    public ActivityTestRule<com.example.marmatsewa.AdminInterface.FourWheelerServices> four=new ActivityTestRule<>(FourWheelerServices.class);
    @Test
    public void FourWheelServiceTest() {

        onView(withId(R.id.btnTForm))
                .perform(click());
    }
}
