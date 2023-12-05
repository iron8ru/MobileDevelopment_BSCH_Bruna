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
                    "too dark" to "consider turing on the lights"
                } else
                    "Perfect" to "Enjoy"
            }
            ActivityType.NAP, ActivityType.STARS -> {
                return if(isDark) {
                    "Perfect" to "Enjoy"
                } else {
                    "too bright" to "consider turning off the lights"
                }
            }
            else -> { "" to "" }
        }
    }

    private fun getActivityChosen(activityType: ActivityType): String {
        return when(activityType) {
            ActivityType.READ -> "read a book"
            ActivityType.NAP -> "take a nap"
            ActivityType.CAT -> "look for your cat"
            ActivityType.STARS -> "look at the stars"
            ActivityType.UNKNOWN -> ""
        }
    }
}