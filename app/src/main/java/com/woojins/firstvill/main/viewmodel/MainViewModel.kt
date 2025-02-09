package com.woojins.firstvill.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.woojins.firstvill.main.data.repository.Repository

class MainViewModel : ViewModel() {

    private val repository = Repository()

    private val _uiState = MutableStateFlow("Welcome FirstVill app!")
    val uiState: StateFlow<String> = _uiState

    fun updateMessage() {
        viewModelScope.launch {
            _uiState.value = repository.getNewMessage()
        }
    }
}