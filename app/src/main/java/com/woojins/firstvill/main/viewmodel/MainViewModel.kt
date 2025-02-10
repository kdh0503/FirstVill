package com.woojins.firstvill.main.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.woojins.firstvill.main.data.repository.Repository
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

    private val repository = Repository()

    private val _uiState = MutableStateFlow("Welcome FirstVill app!")
    private val _currentScene = MutableStateFlow("Home")
    val uiState: StateFlow<String> = _uiState
    val currentScene: StateFlow<String> = _currentScene.asStateFlow()

    fun updateMessage() {
        viewModelScope.launch {
            _uiState.value = repository.getNewMessage()
        }
    }

    fun navigateTo(scene: String) {
        viewModelScope.launch {
            Log.d("dh503kim", "current scene changed = $scene")
            _currentScene.value = scene
        }
    }
}