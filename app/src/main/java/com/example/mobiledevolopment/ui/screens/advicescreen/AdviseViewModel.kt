package com.example.mobiledevolopment.ui.screens.advicescreen

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
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
}