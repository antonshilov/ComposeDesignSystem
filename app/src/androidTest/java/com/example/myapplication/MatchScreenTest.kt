package com.example.myapplication

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.example.myapplication.samples.MatchScreen
import com.example.myapplication.samples.TestTagMatchScreen
import com.example.myapplication.samples.matchConfig
import com.example.myapplication.ui.theme.BadooTheme
import org.junit.Rule
import org.junit.Test

class MatchScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private fun launchScreen() {
        composeTestRule.setContent {
            BadooTheme {
                val config = matchConfig()
                MatchScreen(config = config)
            }
        }
    }

    @Test
    fun matchScreenTest() {
        launchScreen()

        with(composeTestRule) {
            onNodeWithTag(TestTagMatchScreen.matchPhotos).assertIsDisplayed()

            onNodeWithTag(TestTagMatchScreen.cta)
                .assertIsDisplayed()
                .assertTextEquals("Send Message")
                .performClick()
        }
    }


}

