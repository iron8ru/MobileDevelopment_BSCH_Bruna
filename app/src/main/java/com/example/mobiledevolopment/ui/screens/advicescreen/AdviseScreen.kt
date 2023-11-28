package com.example.mobiledevolopment.ui.screens.advicescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobiledevolopment.ui.screens.theme.AdviseComposable
import com.example.mobiledevolopment.ui.screens.theme.TextWithShadow
import com.example.mobiledevolopment.R
import com.example.mobiledevolopment.navigation.ActivityType
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AdviseScreen(
    nameEntered: String?,
    activityType: ActivityType,
    viewModel: AdviseViewModel = viewModel()
) {

    Surface(
        modifier = Modifier.fillMaxSize()

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)

        ) {
            val isDark = viewModel.isDark
            val roomLightText = if (isDark) "dark" else "bright"
            val lightActionText = if (isDark) "On" else "Off"
            val cardBackground = if(isDark) Color.DarkGray else Color.Yellow
            val textColor = if(isDark) Color.White else Color.Black
            val activityText = when(activityType) {
                ActivityType.READ -> "read a book"
                ActivityType.NAP -> "a nap"
                ActivityType.CAT -> "find your cat"
                ActivityType.STARS -> "looking at stars"
                ActivityType.UNKNOWN -> "unknown activity"
            }
            Spacer(modifier = Modifier.size(20.dp))
            TextWithShadow(
                value = "Thanks for asking, $nameEntered!",
                25.sp,
                textAlign = TextAlign.Center,
                colorValue = if (isDark) Color.White else Color.Black
            )
            Spacer(modifier = Modifier.size(30.dp))
            AdviseComposable(
                roomLight = "The room is too $roomLightText for $activityText!",
                lightAction = "Consider turning $lightActionText the lights!",
                image = R.drawable.cat3_reduce,
                cardBackground = cardBackground,
                textColor = textColor
            )

        }

    }
}


@Preview
@Composable
fun AdviseScreenPreview() {
    AdviseScreen(nameEntered = "username", activityType = ActivityType.UNKNOWN)
}
