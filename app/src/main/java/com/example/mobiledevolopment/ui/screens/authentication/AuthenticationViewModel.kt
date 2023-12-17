package com.example.mobiledevolopment.ui.screens.authentication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobiledevolopment.data.repository.FirebaseAuthenticationRepo
import com.example.mobiledevolopment.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthenticationViewModel : ViewModel() {
    // Repository for handling authentication using Firebase
    private val authenticationRepo = FirebaseAuthenticationRepo()

    // MutableStateFlow to represent the UI state with nullable Resource<String> type
    private val _uiState = MutableStateFlow<Resource<String>?>(null)
    // StateFlow for observation in the UI layer
    val uiState = _uiState.asStateFlow()

    //user registration
    fun register(email: String, password: String) {
        // Start a coroutine in the viewModelScope to perform the registration
        viewModelScope.launch {
            _uiState.value = Resource.Loading
            // Perform registration and update UI state based on the result
            when(val result = authenticationRepo.register(email, password)){
                is Resource.Error -> {
                    _uiState.value = Resource.Error(throwable = result.throwable )
                }
                is Resource.Loading -> {
                    _uiState.value = Resource.Loading
                }
                is Resource.Success -> {
                    _uiState.value = Resource.Success(data = email)
                }
            }
        }
    }

    // user login
    fun login(email: String, password: String) {
        viewModelScope.launch {
            _uiState.value = Resource.Loading
            // Perform login and update UI state based on the result
            when(val result = authenticationRepo.login(email, password)){
                is Resource.Error -> {
                    _uiState.value = Resource.Error(throwable = result.throwable )
                }
                is Resource.Loading -> {
                    _uiState.value = Resource.Loading
                }
                is Resource.Success -> {
                    _uiState.value = Resource.Success(data = email)
                }
            }
        }
    }
}