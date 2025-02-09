package com.woojins.firstvill.main.ui.screens

import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.compose.rememberNavController
import com.woojins.firstvill.main.ui.screens.OnBoarding.onBoardingScreen
import com.woojins.firstvill.main.viewmodel.MainViewModel
import org.junit.Rule
import org.junit.jupiter.api.Test

class OnBoardingTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `Text must be Login at first time`() {
        composeTestRule.setContent {
            val mainViewModel = MainViewModel()
            val navController = rememberNavController()
            onBoardingScreen(navController, mainViewModel)
        }

        // 초기 값 확인
        composeTestRule.onNodeWithTag("Text").assertTextContains("Login")
    }
}