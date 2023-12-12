package com.example.mobiledevolopment.sensor_data

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager


// Abstract base class for Android sensors, extending MeasurableSensor and implementing SensorEventListener.
abstract class AndroidSensor(
    private val context: Context,
    private val sensorFeature: String,
    sensorType: Int
) : MeasurableSensor(sensorType), SensorEventListener {
    // Override property to check if the sensor exists on the device based on the specified feature.
    override val doesSensorExist: Boolean
        get() = context.packageManager.hasSystemFeature(sensorFeature)
    // SensorManager and Sensor instances for managing sensor events.
    private lateinit var sensorManager: SensorManager
    private var sensor: Sensor? = null

    // Function to start listening for sensor events.
    override fun startListening() {
        // If the sensor doesn't exist, return early.
        if (!doesSensorExist) {
            return
        }
        if (!::sensorManager.isInitialized && sensor == null) {
            sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
            sensor = sensorManager.getDefaultSensor(sensorType)
        }
        sensor?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    // Function to stop listening for sensor events.
    override fun stopListening() {
        // If the sensor doesn't exist or SensorManager is not initialized, return early.
        if (!doesSensorExist || !::sensorManager.isInitialized) {
            return
        }
        // Unregister the sensor listener.
        sensorManager.unregisterListener(this)
    }

    // Callback function triggered when the sensor values change.
    override fun onSensorChanged(event: SensorEvent?) {
        // If the sensor doesn't exist, return early.
        if (!doesSensorExist) {
            return
        }
        // If the event corresponds to the expected sensor type, invoke the callback.
        if (event?.sensor?.type == sensorType) {
            onSensorValuesChanged?.invoke(event.values.toList())
        }
    }

    // Callback function triggered when the sensor accuracy changes (not used in this implementation).
    override fun onAccuracyChanged(p0: Sensor?, p1: Int) = Unit
}
