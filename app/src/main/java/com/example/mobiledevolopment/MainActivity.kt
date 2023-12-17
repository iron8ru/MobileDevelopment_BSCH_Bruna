package com.example.mobiledevolopment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.mobiledevolopment.navigation.RoomLightAdvNavigationGraph
import com.example.mobiledevolopment.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        // Install splash screen
        installSplashScreen()
        //Set the content of the activity using Jetpack Compose
        setContent {
            MyApplicationTheme {
                // Call the RoomLightAdvApp composable function to set up the app UI
                RoomLightAdvApp()

            }
        }
    }

    @Composable
    fun RoomLightAdvApp(){
        // Call the RoomLightAdvNavigationGraph composable function to define app navigation
        RoomLightAdvNavigationGraph()

    }


}