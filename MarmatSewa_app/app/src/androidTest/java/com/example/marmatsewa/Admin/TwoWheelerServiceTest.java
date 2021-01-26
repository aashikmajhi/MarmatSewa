package com.example.marmatsewa.Admin;

import androidx.test.rule.ActivityTestRule;

import com.example.marmatsewa.AdminInterface.TwoWheelerServices;
import com.example.marmatsewa.Dashboard.FourWheelerServices;
import com.example.marmatsewa.R;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class TwoWheelerServiceTest {
    @Rule
    public ActivityTestRule<TwoWheelerServices> four=new ActivityTestRule<>(TwoWheelerServices.class);
    @Test
    public void FourWheelServiceTest() {

        onView(withId(R.id.btnFForm))
                .perform(click());
    }
}
