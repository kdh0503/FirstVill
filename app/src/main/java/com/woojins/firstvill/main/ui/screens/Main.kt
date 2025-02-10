package com.woojins.firstvill.main.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.woojins.firstvill.main.viewmodel.MainViewModel

object Main {
    @Composable
    fun mainScreen(viewModel: MainViewModel) {
        val currentScene by viewModel.currentScene.collectAsState()

        when (currentScene) {
            "Home" -> HomeScene(viewModel)
            "Notification" -> NotificationScene(viewModel)
        }
    }

    @Composable
    fun HomeScene(viewModel: MainViewModel) {
        Scaffold(
            topBar = {
                HeaderWithButtons(
                    onMenuClick = { /* TODO: 메뉴 기능 추가 */ },
                    onNotificationClick = { viewModel.navigateTo("Notification")},
                )
            },
            bottomBar = { Footer() }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text("Main Content Here")
            }
        }
    }

    @Composable
    fun NotificationScene(viewModel: MainViewModel) {
        Scaffold(
            topBar = {
                HeaderWithButtonsOnNotification(
                    onBackClick = { viewModel.navigateTo("Home") },
                    onMenuClick = { /* TODO: 메뉴 기능 추가 */ },
                )
            },
            bottomBar = { Footer() }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text("Notification Content Here")
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun HeaderWithButtonsOnNotification(onBackClick: () -> Unit, onMenuClick: () -> Unit) {
        TopAppBar(
            title = { Text("Notification page") },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },
            actions = {
                IconButton(onClick = onMenuClick) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu")
                }
            },
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun HeaderWithButtons(onMenuClick: () -> Unit, onNotificationClick: () -> Unit) {
        TopAppBar(
            title = { Text("Main page") },
            actions = {
                IconButton(onClick = onNotificationClick) {
                    Icon(Icons.Default.Notifications, contentDescription = "Notification")
                }
                IconButton(onClick = onMenuClick) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu")
                }
            },
        )
    }

    @Composable
    fun Footer() {
        BottomAppBar(
            containerColor = Color.DarkGray, // 배경색 설정
            contentColor = Color.White // 아이콘 색상 설정
        ) {
            IconButton(onClick = { /* TODO: Home 클릭 */ }, Modifier.weight(1f)) {
                Icon(Icons.Filled.Home, contentDescription = "Home")
            }
            IconButton(onClick = { /* TODO: Search 클릭 */ }, Modifier.weight(1f)) {
                Icon(Icons.Filled.Search, contentDescription = "Search")
            }
            IconButton(onClick = { /* TODO: Settings 클릭 */ }, Modifier.weight(1f)) {
                Icon(Icons.Filled.Settings, contentDescription = "Settings")
            }
            Spacer(Modifier.weight(1f))
        }
    }
}