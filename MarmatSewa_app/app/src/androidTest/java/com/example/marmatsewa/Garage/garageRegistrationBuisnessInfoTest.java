package com.example.marmatsewa;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import com.example.marmatsewa.Registration.garageRegistrationBusinessInfo;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;

import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class garageRegistrationBuisnessInfoTest {

    @Rule
    public ActivityTestRule<garageRegistrationBusinessInfo> testRule=new ActivityTestRule<>(garageRegistrationBusinessInfo.class);

    @Test
    public void GarageRegistrationTest() {
        onView(ViewMatchers.withId(R.id.checkBoxControlBrake))
                .perform(typeText(true))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.checkBoxElectrical))
                .perform(typeText(true))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.checkBoxFuelAir))
                .perform(typeText(true))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.checkBoxWheelDrives))
                .perform(typeText(true))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.btnRegisterWorkshop))
                .perform(click());

    }
}

