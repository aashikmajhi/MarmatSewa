package com.example.marmatsewa.Garage;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.garageRegistration;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class GarageRegistrationTest {
    @Rule
    public ActivityTestRule<garageRegistration> testRule=new ActivityTestRule<>(garageRegistration.class);

    @Test
    public void GarageRegistrationTest() {
        onView(ViewMatchers.withId(R.id.garageName))
                .perform(typeText("aashik.majhi1234@gmail.com"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.edtGaragePassword))
                .perform(typeText("Ashik@123"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.btnNext))
                .perform(click());

    }
}
