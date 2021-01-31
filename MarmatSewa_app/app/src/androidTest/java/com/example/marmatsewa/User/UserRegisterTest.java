package com.example.marmatsewa.User;



import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.userRegistration;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class UserRegisterTest {
    @Rule
    public ActivityTestRule<userRegistration>testRule=new ActivityTestRule<>(userRegistration.class);
    @Test
    public void RegisterUserTest() {
        onView(ViewMatchers.withId(R.id.edtfName))
                .perform(typeText("Aashik Majhi"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.edtEmail))
                .perform(typeText("ashik.majhi@gmail.com"))
                .perform(closeSoftKeyboard());

        onView(ViewMatchers.withId(R.id.edtPassword))
                .perform(typeText("Aashikmajhi"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.edtPhone))
                .perform(typeText("9841234567"))
                .perform(closeSoftKeyboard());

        onView(ViewMatchers.withId(R.id.edtAddress))
                .perform(typeText("Boudha"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.edtDob))
                .perform(typeText("1990-12-12"))
                .perform(closeSoftKeyboard());

        onView(ViewMatchers.withId(R.id.genderMale))
                .perform(typeText("MALE"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.submitUser))
                .perform(click());

    }
}
