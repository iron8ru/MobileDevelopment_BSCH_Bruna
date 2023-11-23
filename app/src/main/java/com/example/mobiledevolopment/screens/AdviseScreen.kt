package com.example.mobiledevolopment.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobiledevolopment.Components.AdviseComposable
import com.example.mobiledevolopment.Components.TextWithShadow
import com.example.mobiledevolopment.R

@Composable
fun AdviseScreen(nameEntered: String?, cardSelected: String?) {
    println("=====Inside+AdviseScreen")
    println("======and $cardSelected")
    var roomLight = "dark" // import the room light from the sensordataViewModel
    var activityChosen = "finding your cat" // this one is to be according to the cardSelected
    var onOrOff = "on" // make this a boolean with condition print On or Off
    Surface(
        modifier = Modifier.fillMaxSize()

    ) {
        Column  (
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)

        ){


            Spacer(modifier = Modifier.size(20.dp))
            TextWithShadow(value = "Thanks for asking, $nameEntered!", 25.sp, textAlign = TextAlign.Center, colorValue= Color.Black)
            Spacer(modifier = Modifier.size(30.dp))
            AdviseComposable(
                value1 = "The room is too $roomLight for $activityChosen!",
                value2 = "Consider turning $onOrOff the lights!",
                image = R.drawable.cat3_reduce
            )

        }

    }
}


@Preview
@Composable
fun AdviseScreenPreview() {
    AdviseScreen("username", "cardSelected")
}