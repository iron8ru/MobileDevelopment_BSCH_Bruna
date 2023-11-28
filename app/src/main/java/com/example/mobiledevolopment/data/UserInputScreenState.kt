package com.example.mobiledevolopment.data

import com.example.mobiledevolopment.navigation.ActivityType

data class UserInputScreenState (
    var nameEntered : String = "" ,
    var activitySelected: ActivityType = ActivityType.UNKNOWN
)