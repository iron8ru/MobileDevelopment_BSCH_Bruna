package com.example.mobiledevolopment
import android.app.Application
import com.google.firebase.FirebaseApp

class MyApp: Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}