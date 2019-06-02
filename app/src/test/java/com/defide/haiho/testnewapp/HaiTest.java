package com.defide.haiho.testnewapp;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HaiTest {
    private MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.buildActivity(MainActivity.class).create().resume().get();
    }

    @Test
    public void shouldNotBeNull() {
        assertNotNull(activity);
    }

    @Test
    public void testClick() {
        TextView tvHello = activity.findViewById(R.id.tvHello);
        Button btnClick = activity.findViewById(R.id.btnClick);
        btnClick.callOnClick();
        assertEquals("Clicked 0", tvHello.getText().toString());

        btnClick.callOnClick();
        btnClick.callOnClick();
        btnClick.callOnClick();
        btnClick.callOnClick();
        assertEquals("Clicked 4", tvHello.getText().toString());
    }

    @Test
    public void testInput() {
        TextView tvHello = activity.findViewById(R.id.tvHello);
        EditText edInput = activity.findViewById(R.id.edInput);
        String input = "Hahaha";
        edInput.setText(input);
        assertEquals(input, tvHello.getText().toString());

        input += "ok";
        edInput.setText(input);
        assertEquals(input, tvHello.getText().toString());
    }

    @Test
    public void testNavigation() {
        activity.findViewById(R.id.btnNext).callOnClick();
        Intent expectedIntent = new Intent(activity, SecondActivity.class);
        Intent actualIntent = shadowOf(activity).peekNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }

    @Test
    public void testFragment() {
        SecondFragment fragment = new SecondFragment();
        SupportFragmentTestUtil.startVisibleFragment(fragment);
        assertNotNull(fragment.getView());

        fragment.getView().findViewById(R.id.btnSecond).callOnClick();
        assertEquals(((TextView) fragment.getView().findViewById(R.id.tvSecond)).getText().toString(), "CLICKED");

        assertEquals(fragment.yourAge(8), "Your age is 8");
    }

    @Test
    public void testPrivateMethod() {
        assertEquals(activity.yourAge(8), "Your age is 8");
    }
}
