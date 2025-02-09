package com.woojins.firstvill.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.woojins.firstvill.main.ui.screens.Login.loginScreen
import com.woojins.firstvill.main.viewmodel.LoginViewModel
import com.woojins.firstvill.main.ui.screens.OnBoarding.onBoardingScreen
import com.woojins.firstvill.main.ui.screens.Main.mainScreen
import com.woojins.firstvill.main.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation(loginViewModel, viewModel)
        }
    }
}

@Composable
fun AppNavigation(loginViewModel: LoginViewModel, mainViewModel: MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "onboarding") {
        composable("login") { loginScreen(navController, loginViewModel) }
        composable("onboarding") { onBoardingScreen(navController, mainViewModel) }
        composable("main") { mainScreen() }
    }
}