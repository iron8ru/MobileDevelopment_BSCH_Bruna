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
        installSplashScreen()
        setContent {
            MyApplicationTheme {
                RoomLightAdvApp()

            }
        }
    }

    @Composable
    fun RoomLightAdvApp(){
        RoomLightAdvNavigationGraph()

    }


}