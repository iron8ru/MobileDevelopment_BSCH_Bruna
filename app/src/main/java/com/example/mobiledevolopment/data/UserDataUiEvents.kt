package com.example.mobiledevolopment.data

import com.example.mobiledevolopment.navigation.ActivityType

sealed class UserDataUiEvents{
    data class UserNameEntered(val name:String) : UserDataUiEvents()
    data class ActivitySelected(val activityType: ActivityType) : UserDataUiEvents()


}