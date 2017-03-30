package in.chroot.belajarunittest;

import android.content.Intent;
import android.support.test.espresso.Root;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

/**
 * Created by yogi on 30/03/17.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {


    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    /**
     * Test widget yang di tampilkan
     */
    @Test
    public void checkViewDisplayed(){
        activityActivityTestRule.launchActivity(new Intent());
        onView(withId(R.id.et_username)).check(matches(isDisplayed()));
        onView(withId(R.id.et_pass)).check(matches(isDisplayed()));
        onView(withId(R.id.bt_login)).check(matches(isDisplayed()));}


    /**
     * Test Jika username atau password belum dimasukan
     */
    @Test
    public void checkUsernameAndPasswordNull(){
        MainActivity mainActivity = activityActivityTestRule.getActivity();
        onView(withId(R.id.bt_login)).check(matches(isDisplayed())).perform(click());
        onView(withText("Username and password tidak boleh kosong")).inRoot(withDecorView(not(is(mainActivity.getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    /**
     * Test jika login sukses
     */
    @Test
    public void checkIfLoginSucess(){
        String username ="android";
        String pass ="dokterdroid";
        MainActivity mainActivity = activityActivityTestRule.getActivity();
        onView(withId(R.id.et_username)).perform(typeText(username));
        onView(withId(R.id.et_pass)).perform(typeText(pass));
        onView(withId(R.id.bt_login)).check(matches(isDisplayed())).perform(click());
        onView(withText("Login Sukses " + username)).inRoot(withDecorView(not(is(mainActivity.getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    /**
     * Test Jika username atau password salah
     */
    @Test
    public void checkWrongText(){
        String username ="androi";
        String pass ="dokterdroi";
        MainActivity mainActivity = activityActivityTestRule.getActivity();
        onView(withId(R.id.et_username)).perform(typeText(username));
        onView(withId(R.id.et_pass)).perform(typeText(pass));
        onView(withId(R.id.bt_login)).check(matches(isDisplayed())).perform(click());
        onView(withText("Username salah atau Pass Salah")).inRoot(withDecorView(not(is(mainActivity.getWindow().getDecorView())))).check(matches(isDisplayed()));
    }


}

