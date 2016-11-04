package com.example.snakechild.app;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.test.ActivityInstrumentationTestCase2;

import br.edu.ufcg.embedded.saojoao.R;
import br.edu.ufcg.embedded.saojoao.activity.MainActivity;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;

/**
 * Created by Laercio Vitorino on 6/8/2015.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    UiDevice mDevice;
    MainActivity mActivity;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        mActivity = getActivity();
        mDevice = UiDevice.getInstance(getInstrumentation());
    }

    public void testMainActivityDisplayed(){
        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()));
    }


    public void testClickActionBarItens() throws Exception{
        onView(withId(R.id.toolbar)).perform(click());
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.action_help)).perform(click());
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));

        onData(anything()).inAdapterView(withId(R.id.ajuda_list)).atPosition(0).perform(click());
        onView(withId(R.id.ajuda_down_label)).check(matches(isDisplayed()));
        onView(withId(R.id.ajuda_list)).perform(swipeDown());
        onView(withId(R.id.ajuda_list)).perform(swipeUp());
        onData(anything()).inAdapterView(withId(R.id.ajuda_list)).atPosition(0).perform(click());

        onView(withId(R.id.toolbar)).perform(pressBack());

        onView(withId(R.id.toolbar)).perform(click());
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.action_about)).perform(click());
        onView(withId(R.id.toolbar)).check(matches(isDisplayed())); // It's necessary to check with the text displayed

        onView(withId(R.id.toolbar)).perform(pressBack());

        /*onView(withId(R.id.toolbar)).perform(click());
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.action_rate)).perform(click());

        mDevice.pressBack();*/

        onView(withId(R.id.toolbar)).perform(click());
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.action_share)).perform(click());

        mDevice.pressBack();
        //mDevice.pressBack();
        //mDevice.findObject(new UiSelector().text("OK")).click();
    }

    public void testClickBottomBarItens() throws Exception {
        // Check whether the bt2 button leads to the maps screen
        onView(allOf(withId(R.id.bt2))).perform(click());
        onView(withId(R.id.map_container)).check(matches(isDisplayed()));

        // Check whether the bt3 button leads to the camera screen
        onView(allOf(withId(R.id.bt3))).perform(click());
        onView(withId(R.id.camera_preview)).check(matches(isDisplayed()));
        onView(withId(R.id.camera_preview)).perform(pressBack());

        // Check whether the bt4 button leads to the search screen
        onView(allOf(withId(R.id.bt4))).perform(click());
        onView(withId(R.id.texto_ajuda_busca)).perform(pressBack());
        onView(withId(R.id.texto_ajuda_busca)).check(matches(isDisplayed()));

        // Check whether the bt5 button leads to the favorites screen
        onView(allOf(withId(R.id.bt5))).perform(click());
        onView(withId(R.id.barra_aviso)).check(matches(isDisplayed()));

        // Check whether the bt1 button leads to the schedule screen
        onView(allOf(withId(R.id.bt1))).perform(click());
        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()));
    }

    public void testScrollScreen(){
        onView(withId(R.id.fragment_container)).perform(swipeDown());
        onView(withId(R.id.fragment_container)).perform(swipeUp());
    }

    public void testClickDaySchedule(){
        onData(anything()).inAdapterView(withId(R.id.eventos_list)).atPosition(0).perform(click());
        onView(allOf(withId(R.id.like_atracao_button), hasSibling(withText("Biliu de Campina")))).perform(click());
        onView(allOf(withId(R.id.video_link), hasSibling(withText("Biliu de Campina")))).perform(click());

        mDevice.pressBack();
    }

    public void testSearchScreen(){
        String textToBeTyped = "Biliu";
        onView(withId(R.id.bt4)).perform(click());
        onView(withId(R.id.search_src_text)).perform(typeText(textToBeTyped));
        onView(withId(R.id.busca_list)).perform(pressBack());
        onView(withId(R.id.search_src_text)).perform(clearText());
    }

    public void testRemindersScreen(){
        onView(withId(R.id.bt5)).perform(click());
        onView(withId(R.id.text_lembretes_aviso)).check(matches(isDisplayed()));
        onView(withId(R.id.switch_notificacao)).perform(click());
        onView(withId(R.id.switch_notificacao)).perform(click());
    }

    public void testMapsScreen() throws InterruptedException, UiObjectNotFoundException {
        onView(withId(R.id.bt2)).perform(click());
        onView(withId(R.id.map_container)).check(matches(isDisplayed()));
        onView(withId(R.id.action_b)).perform(click());
        onView(withId(R.id.action_b)).perform(click());
        onView(withId(R.id.map_container)).check(matches(isDisplayed()));
        onView(withId(R.id.action_c)).perform(click());
        onView(withId(R.id.map_container)).check(matches(isDisplayed()));
        onView(withId(R.id.action_location)).perform(click());
        onView(withId(R.id.bt_cancel)).perform(click());
        onView(withId(R.id.action_location)).perform(click());
        onView(withText(R.string.banheiros)).perform(click());
        onView(withText(R.string.bares)).perform(click());
        onView(withText(R.string.policia)).perform(click());
        onView(withId(R.id.bt_ok));

        /*UiObject marker = mDevice.findObject(new UiSelector().index(R.string.bt_police_point));
        marker.click();
        onView(withId(R.string.shout_route)).perform(click());

        mDevice.pressBack();*/
    }

    public void tearDown() throws Exception {
        getActivity().finish();
        super.tearDown();
    }
}