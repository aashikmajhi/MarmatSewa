package com.example.marmatsewa;

import androidx.test.rule.ActivityTestRule;

import com.example.marmatsewa.AdminInterface.FourWheelerServices;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class FourWheelerServiceAddTest {

    @Rule

    public ActivityTestRule<FourWheelerServices> fourWheelerService = new ActivityTestRule<>(FourWheelerServices.class);

    @Test
    public void FourWheelServiceAddTest() {
        onView(withId(R.id.edtFourWheelServiceName))
                .perform(typeText("Engine Check"))
                .perform(closeSoftKeyboard());
    }
}
