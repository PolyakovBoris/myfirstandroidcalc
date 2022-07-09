package com.example.myfirstandroidcalc;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import org.junit.Rule;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule=
            new ActivityTestRule<>(MainActivity.class);
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.myfirstandroidcalc", appContext.getPackageName());
    }
    @Test
    public void SaveAndReadValues() throws Exception
    {
        Context appContext=InstrumentationRegistry.getInstrumentation().getTargetContext();
        SharedPreferences sharedPreferences = appContext.getSharedPreferences("test", 0);
        SaveValuesHelper saveValuesHelper = new SaveValuesHelper(sharedPreferences);
        Values saveValues = new Values();
        saveValues.setFirstOperation("5");
        saveValues.setSecondOperation("2");
        saveValues.setResult("10");
        saveValuesHelper.saveValues(saveValues);
        Values readValues = saveValuesHelper.readValues();
        assertTrue(saveValues.equalsToValues(readValues));
    }
    @Test
    public void addClick()
    {
        onView(withId(R.id.first)).perform(typeText("5"));
        onView(withId(R.id.second)).perform(typeText("10"));
        onView(withId(R.id.add)).perform(click());
    }


}