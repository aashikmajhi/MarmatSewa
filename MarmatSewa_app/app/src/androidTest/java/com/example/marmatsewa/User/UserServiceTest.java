package com.example.marmatsewa.User;

import android.widget.CheckBox;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import com.example.marmatsewa.R;
import com.example.marmatsewa.Registration.LoginDevelopment.LoginBLL;
import com.example.marmatsewa.UserInterface.user_dashboard;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

public class UserServiceTest {
    @Rule
    public ActivityTestRule<user_dashboard> userService=new ActivityTestRule<>(user_dashboard.class);
    @Before
    public void setUp(){
        LoginBLL loginBLL = new LoginBLL("aashikmajhi@gmail.com", "Password123");
        boolean res = loginBLL.checkLogin();
        assertEquals(true, res);
    }
    @Test
    public void UserServiceTest() {

        onView(withId(R.id.btnTwoWheeler))
                .perform(click());

        onView(withId(R.id.btnFourWheeler))
                .perform(click());
    }

}
