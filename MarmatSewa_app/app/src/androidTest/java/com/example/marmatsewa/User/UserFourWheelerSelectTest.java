package com.example.marmatsewa.User;

import androidx.test.rule.ActivityTestRule;

import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.LoginDevelopment.LoginBLL;
import com.example.marmatsewa.UserInterface.user_dashboard;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

public class UserFourWheelerSelectTest {
    @Rule
    public ActivityTestRule<user_dashboard> userService = new ActivityTestRule<>(user_dashboard.class);

    @Before
    public void setUp() {
        LoginBLL loginBLL = new LoginBLL("user@gmail.com", "Password");
        boolean res = loginBLL.checkLogin();
        assertEquals(true, res);
    }

    @Test
    public void UserServiceTest() {


        onView(withId(R.id.btnFourWheel))
                .perform(click());
    }

}
