package com.android.testing

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android.testing.ui.TestingTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    private var activity: MainActivity? = null

    @Before
    fun setUp() {
        activity = composeTestRule.activity
        composeTestRule.setContent {
            TestingTheme {
                MainScreenCounter(MainViewModel())
            }
        }
    }

    @Test
    fun main_initiallyCounterZero() {
        val textClick = activity!!.getString(R.string.clicks, 0)
        composeTestRule.onNodeWithText(textClick).assertExists()
        composeTestRule.onNodeWithText(textClick).assertIsDisplayed()
    }

    @Test
    fun main_incrementCounter() {
        val textClick = activity!!.getString(R.string.clicks, 1)
        composeTestRule.onNodeWithText(activity!!.getString(R.string.increment_number))
            .performClick()
        composeTestRule.onNodeWithText(textClick).assertIsDisplayed()
    }

    @Test
    fun main_NavigateToSecondActivity() {
        val textClick = activity!!.getString(R.string.clicks, 0)

        composeTestRule.onNodeWithText(textClick).assertExists()

        composeTestRule.onNodeWithText(activity!!.getString(R.string.second_screen))
            .performClick()

        composeTestRule.onNodeWithText("Aloha")
            .assertIsDisplayed()
    }
}