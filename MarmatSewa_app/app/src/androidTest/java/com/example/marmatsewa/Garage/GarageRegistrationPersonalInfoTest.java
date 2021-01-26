package com.example.marmatsewa.Garage;

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
    public ActivityTestRule<garageRegistrationPersonalInfo> testRule=new ActivityTestRule<>(garageRegistrationPersonalInfo.class);
    @Test
    public void GarageRegistrationPersonalInfoTest() {
        onView(ViewMatchers.withId(R.id.garageName))
                .perform(typeText("Aashik Motor Maramt Center"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.edtRegType))
                .perform(typeText("PAN"))
                .perform(closeSoftKeyboard());

        onView(ViewMatchers.withId(R.id.edtLocation))
                .perform(typeText("Boudha Opposite of Hyatt Regency Hotel"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.edtContactName))
                .perform(typeText("Sristi Dumre"))
                .perform(closeSoftKeyboard());

        onView(ViewMatchers.withId(R.id.edtNumber))
                .perform(typeText("9819923456"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.edtPanNo))
                .perform(typeText("1128933469"))
                .perform(closeSoftKeyboard());


        onView(withId(R.id.btnNext))
                .perform(click());
    }

    }
