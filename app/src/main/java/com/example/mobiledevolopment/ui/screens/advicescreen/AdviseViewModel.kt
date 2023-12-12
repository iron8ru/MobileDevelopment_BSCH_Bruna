package com.example.mobiledevolopment.ui.screens.advicescreen

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.example.mobiledevolopment.navigation.ActivityType
import com.example.mobiledevolopment.sensor_data.LightSensor

class AdviseViewModel constructor(application: Application): AndroidViewModel(application) {
    val lightSensor = LightSensor(context = application.applicationContext)
    var isDark by mutableStateOf(false)

    init {
        lightSensor.startListening()
        lightSensor.setOnSensorValuesChangedListener { values ->
            val lux = values[0]
            isDark = lux < 60f
        }
    }

    fun getProperMessage(activityType: ActivityType): String {
        val builder = StringBuilder()
        builder.append("The room light is ")
        builder.append(getRoomLightStatus(activityType).first)
        builder.append(" for ")
        builder.append(getActivityChosen(activityType))
        return builder.toString()
    }


    fun getRoomLightStatus(activityType: ActivityType): Pair<String, String> {
        return when(activityType) {
            ActivityType.READ, ActivityType.CAT -> {
                return if(isDark) {
                    "too dark" to "Consider turing on the lights!!"
                } else
                    "perfect" to "Enjoy it!"
            }
            ActivityType.NAP, ActivityType.STARS -> {
                return if(isDark) {
                    "Perfect" to "Enjoy it!"
                } else {
                    "too bright" to "Consider turning off the lights!!"
                }
            }
            else -> { "" to "" }
        }
    }

    private fun getActivityChosen(activityType: ActivityType): String {
        return when(activityType) {
            ActivityType.READ -> "reading a book!"
            ActivityType.NAP -> "taking a nap!"
            ActivityType.CAT -> "looking for your cat!"
            ActivityType.STARS -> "looking at the stars!"
            ActivityType.UNKNOWN -> ""
        }
    }
}