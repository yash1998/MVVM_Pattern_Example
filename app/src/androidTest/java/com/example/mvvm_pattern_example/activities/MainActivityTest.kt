package com.example.mvvm_pattern_example.activities

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.example.mvvm_pattern_example.MainActivity
import com.example.mvvm_pattern_example.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    /**
     * entered empty username and password
     * clicked login button
     * result -> login status set to "login error" and color red
     */
    @Test
    fun testLoginStatusEmptyFields_error() {
        // find the view and performed click on it
        onView(withId(R.id.button_login)).perform(click())

        // find the result reflecting view and asserting the result on it
        onView(withId(R.id.text_login_status)).check(matches(withText("Login Error")))
        onView(withId(R.id.text_login_status)).check(matches(hasTextColor(R.color.red)))
    }

    @Test
    fun testLoginStatusInvalidUsernameLength_error() {
        onView(withId(R.id.edit_text_username)).perform(typeText("abcd"))
        onView(withId(R.id.edit_text_password)).perform(typeText("12345"))
        onView(withId(R.id.button_login)).perform(click())
        onView(withId(R.id.text_login_status)).check(matches(withText("Login Error")))
    }

    @Test
    fun testLoginStatusInvalidPasswordLength_error() {
        onView(withId(R.id.edit_text_username)).perform(typeText("abcde"))
        onView(withId(R.id.edit_text_password)).perform(typeText("1234"))
        onView(withId(R.id.button_login)).perform(click())
        onView(withId(R.id.text_login_status)).check(matches(withText("Login Error")))
    }

    @Test
    fun testLoginStatusInvalidCharsInUsername_error() {
        onView(withId(R.id.edit_text_username)).perform(typeText("ab@cd"))
        onView(withId(R.id.edit_text_password)).perform(typeText("12345"))
        onView(withId(R.id.button_login)).perform(click())
        onView(withId(R.id.text_login_status)).check(matches(withText("Login Error")))
    }

    /**
     * entered empty username and password
     * clicked login button
     * result -> login status set to "login success" and color "green"
     */
    @Test
    fun testLoginStatus_success() {
        onView(withId(R.id.edit_text_username)).perform(typeText("abcde"))
        onView(withId(R.id.edit_text_password)).perform(typeText("12345"))
        onView(withId(R.id.button_login)).perform(click())
        onView(withId(R.id.text_login_status)).check(matches(withText("Login Success")))
        onView(withId(R.id.text_login_status)).check(matches(hasTextColor(R.color.green)))
    }
}