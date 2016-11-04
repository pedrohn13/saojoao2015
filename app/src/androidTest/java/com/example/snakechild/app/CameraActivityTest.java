package com.example.snakechild.app;

import android.test.ActivityInstrumentationTestCase2;

import br.edu.ufcg.embedded.saojoao.R;
import br.edu.ufcg.embedded.saojoao.activity.CameraActivity;
import br.edu.ufcg.embedded.saojoao.activity.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by projeto-aoc on 12/06/15.
 */
public class CameraActivityTest extends ActivityInstrumentationTestCase2<CameraActivity> {
    public CameraActivityTest() {
        super(CameraActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testCameraSwitch(){
        //onView(withId(R.id.bt3)).perform()
        onView(withId(R.id.button_switch_camera)).perform(click());
        onView(withId(R.id.button_switch_camera)).perform(click());
    }

    /*public void testCameraClose() throws InterruptedException {
        onView(withId(R.id.button_close)).perform(click());
    }*/

    public void tearDown() throws Exception {
        getActivity().finish();
        super.tearDown();
    }
}
