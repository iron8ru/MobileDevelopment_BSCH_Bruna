package com.example.mobiledevolopment.sensor_data

//Create abstract base class for MeasurableSensor
abstract class MeasurableSensor(
    protected val sensorType: Int
) {
    //Define a callback to handle sensor value changes.
    protected var onSensorValuesChanged: ((List<Float>) -> Unit)? = null

    abstract val doesSensorExist: Boolean

    //abstract methods for starting and stopping sensor data listening
    abstract fun startListening()
    abstract fun stopListening()

    //Method to set the listener for sensor value changes.
    fun setOnSensorValuesChangedListener(listener: (List<Float>) -> Unit) {
        onSensorValuesChanged = listener
    }
}