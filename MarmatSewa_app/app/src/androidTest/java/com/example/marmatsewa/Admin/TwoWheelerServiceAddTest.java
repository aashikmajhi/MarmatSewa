package com.example.marmatsewa.Admin;

import android.app.Activity;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import com.example.marmatsewa.AdminInterface.TwoWheelerServices;
import com.example.marmatsewa.R;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class TwoWheelerServiceAddTest {

@Rule
    public ActivityTestRule<TwoWheelerServices> twoWheelerServices=new ActivityTestRule<>(TwoWheelerServices.class);
    @Test
    public void FourWheelServiceAddTest() {
        onView(ViewMatchers.withId(R.id.edtTwoWheelServiceName))
                .perform(typeText("Fuel leakage"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.btnAddService))
                .perform(click());
    }
}

