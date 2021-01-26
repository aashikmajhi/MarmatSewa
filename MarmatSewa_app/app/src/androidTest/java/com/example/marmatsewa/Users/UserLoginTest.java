package com.example.marmatsewa.Users;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.LoginActivity;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class UserLoginTest {
    @Rule
public ActivityTestRule<LoginActivity>testRule=new ActivityTestRule<>(LoginActivity.class);
    @Test
    public void LoginTest() {
        onView(ViewMatchers.withId(R.id.edtEmail))
                .perform(typeText("nitesh.katwal20@gmail.com"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.edtPword))
                .perform(typeText("Nit3sh@123"))
                .perform(closeSoftKeyboard());

        onView(withId(R.id.btnLogin))
                .perform(click());

    }
}

