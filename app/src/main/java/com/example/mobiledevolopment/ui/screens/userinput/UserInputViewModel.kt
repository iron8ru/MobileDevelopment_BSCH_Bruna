package com.example.mobiledevolopment.ui.screens.userinput

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mobiledevolopment.data.UserDataUiEvents
import com.example.mobiledevolopment.data.UserInputScreenState
import com.example.mobiledevolopment.navigation.ActivityType

class UserInputViewModel : ViewModel() {
    var uiState = mutableStateOf(UserInputScreenState())

    fun onEvent(event: UserDataUiEvents) {
        when (event) {
            // When the user enters their name, update the name in the UI state
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )

            }
            // When the user selects an activity, update the selected activity in the UI state
            is UserDataUiEvents.ActivitySelected -> {
                uiState.value = uiState.value.copy(
                    activitySelected = event.activityType
                )
            }
        }
    }

    // Function to check if the current UI state is considered valid
    fun isValidState(): Boolean {
        return uiState.value.nameEntered.isNotEmpty() &&
                uiState.value.activitySelected != ActivityType.UNKNOWN
    }
}


