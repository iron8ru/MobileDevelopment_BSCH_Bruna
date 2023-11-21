package com.example.mobiledevolopment.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mobiledevolopment.data.UserDataUiEvents
import com.example.mobiledevolopment.data.UserInputScreenState

class UserInputViewModel : ViewModel() {
    var uiState = mutableStateOf(UserInputScreenState())

    fun onEvent(event: UserDataUiEvents) {
        when (event) {
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )

            }

            is UserDataUiEvents.CardSelected -> {
                uiState.value = uiState.value.copy(
                    cardSelected = event.cardValue
                )
            }
        }
    }

    fun isValidState(): Boolean {
        return !uiState.value.nameEntered.isNullOrEmpty() &&
                !uiState.value.cardSelected.isNullOrEmpty()
    }
}