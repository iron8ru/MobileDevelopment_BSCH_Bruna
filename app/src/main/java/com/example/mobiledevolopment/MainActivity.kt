package com.example.mobiledevolopment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobiledevolopment.screens.RoomLightAdvNavigationGraph
import com.example.mobiledevolopment.theme.MobileDevolopmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileDevolopmentTheme {
                RoomLightAdvApp()

            }
        }
    }

    @Composable
    fun RoomLightAdvApp(){
        RoomLightAdvNavigationGraph()

    }


}
//
//@AndroidEntryPoint
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            SensorGuideTheme {
//                val viewModel = viewModel<MainViewModel>()
//                val isDark = viewModel.isDark
//                Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(
//                            if (isDark) Color.DarkGray else Color.White
//                        ),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Text(
//                        text = if(isDark) {
//                            "It's dark outside"
//                        } else {
//                            "It's bright outside"
//                        },
//                        color = if(isDark) Color.White else Color.DarkGray
//                    )
//                }
//            }
//        }
//    }
//}
