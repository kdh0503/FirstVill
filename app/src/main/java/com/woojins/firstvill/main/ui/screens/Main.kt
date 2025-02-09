package com.woojins.firstvill.main.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object Main {
    @Composable
    fun mainScreen() {
        Scaffold(
            topBar = {
                HeaderWithButtons(
                    onBackClick = { /* TODO: 뒤로 가기 기능 추가 */ },
                    onMenuClick = { /* TODO: 메뉴 기능 추가 */ }
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

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun HeaderWithButtons(onBackClick: () -> Unit, onMenuClick: () -> Unit) {
        TopAppBar(
            title = { Text("Header with Buttons") },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },
            actions = {
                IconButton(onClick = onMenuClick) {
                    Icon(Icons.Default.MoreVert, contentDescription = "Menu")
                }
            },
        )
    }

    @Composable
    fun Footer() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            Text("Footer", color = Color.White, fontSize = 20.sp)
        }
    }
}