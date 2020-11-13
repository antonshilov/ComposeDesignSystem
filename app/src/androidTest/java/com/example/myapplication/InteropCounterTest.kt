package com.example.myapplication

import androidx.compose.ui.test.onNodeWithText
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.ui.test.createComposeRule
import com.example.myapplication.samples.ViewComposeInterop
import org.junit.Rule
import org.junit.Test

class InteropCounterTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun interopTest() {
        launchScreen()

        onView(ViewMatchers.withContentDescription("CounterAndroidView"))
            .perform(click())
            .check(matches(withText("Hello From AndroidViews World! Count = 1")))

        composeTestRule.onNodeWithText("Compose Text Count = 1").assertExists()

    }

    private fun launchScreen() {
        composeTestRule.setContent {
            ViewComposeInterop()
        }
    }
}

