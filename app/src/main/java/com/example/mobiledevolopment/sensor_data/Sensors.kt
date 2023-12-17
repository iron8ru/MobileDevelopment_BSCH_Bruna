package com.example.mobiledevolopment.sensor_data

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor

//LightSensor class represents a light sensor in Android.
class LightSensor(
    context: Context
): AndroidSensor(
    context = context,
    // Specifying the feature required for the light sensor
    sensorFeature = PackageManager.FEATURE_SENSOR_LIGHT,
    // Specifying the type of the sensor
    sensorType = Sensor.TYPE_LIGHT
)