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

public class FourWheelerServiceAddTest {

    @Rule

    public ActivityTestRule<FourWheelerServices> fourWheelerService = new ActivityTestRule<>(FourWheelerServices.class);

    @Test
    public void FourWheelServiceAddTest() {
        onView(ViewMatchers.withId(R.id.edtFourWheelServiceName))
                .perform(typeText("Engine Check"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.btnAddService))
                .perform(click());
    }
}
