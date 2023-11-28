package com.example.mobiledevolopment.ui.screens.authentication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobiledevolopment.data.repository.FirebaseAuthenticationRepo
import com.example.mobiledevolopment.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthenticationViewModel : ViewModel() {
    private val authenticationRepo = FirebaseAuthenticationRepo()

    private val _uiState = MutableStateFlow<Resource<String>?>(null)
    val uiState = _uiState.asStateFlow()

    fun register(email: String, password: String) {
        viewModelScope.launch {
            _uiState.value = Resource.Loading
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

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _uiState.value = Resource.Loading
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