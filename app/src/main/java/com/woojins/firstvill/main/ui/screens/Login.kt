package com.woojins.firstvill.main.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.woojins.firstvill.main.viewmodel.LoginViewModel

object Login {

    @Composable
    fun loginScreen(navigationBarHostController: NavHostController, viewModel: LoginViewModel) {
        var loginStatus by remember { mutableStateOf("로그인 필요") }
        var isLoggedIn by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    viewModel.loginWithKakao { success, token ->
                        isLoggedIn = success
                        loginStatus = if (success) "로그인 성공! 토큰: $token" else "로그인 실패"
                        navigationBarHostController.navigate("Main") // TODO dh503.kim fix it
                    }
                }
            ) {
                Text("카카오 계정으로 로그인")
            }

            Button(
                onClick = {
                    // TODO
                    navigationBarHostController.navigate("Main") // TODO dh503.kim fix it
                }
            ) {
                Text("네이버 계정으로 로그인")
            }

            Button(
                onClick = {
                    // TODO
                    navigationBarHostController.navigate("Main") // TODO dh503.kim fix it
                }
            ) {
                Text("구글 계정으로 로그인")
            }
        }
    }
}