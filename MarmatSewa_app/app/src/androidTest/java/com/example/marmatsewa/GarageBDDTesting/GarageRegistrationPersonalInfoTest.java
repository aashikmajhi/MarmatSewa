package com.example.marmatsewa.GarageBDDTesting;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.garageRegistrationPersonalInfo;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class GarageRegistrationPersonalInfoTest {

    @Rule
    public ActivityTestRule<garageRegistrationPersonalInfo> garageTestRule = new ActivityTestRule<>(garageRegistrationPersonalInfo.class);

    @Test
    public void GarageRegistrationPersonalInfoTest() {
        onView(ViewMatchers.withId(R.id.garageName))
                .perform(typeText("Aashik Motorcycle Workshop"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.edtRegType))
                .perform(typeText("PAN"))
                .perform(closeSoftKeyboard());

        onView(ViewMatchers.withId(R.id.edtLocation))
                .perform(typeText("Boudha"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.edtContactName))
                .perform(typeText("Aashik Majhi"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.edtNumber))
                .perform(typeText("9819978945"))
                .perform(closeSoftKeyboard());


        onView(withId(R.id.edtPanNo))
                .perform(typeText("123456789"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.register))
                .perform(click());

    }
}
