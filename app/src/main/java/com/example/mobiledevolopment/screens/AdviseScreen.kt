package com.example.mobiledevolopment.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AdviseScreen(navController: String?, cardSelected: String?) {
    println("=====Inside+AdviseScreen")
    println("======and $cardSelected")
    Surface(
        modifier = Modifier.fillMaxSize()

    ) {
        Text(
            modifier = Modifier
                .fillMaxSize()
                .height(80.dp),
            text = Routes.ADVISE_SCREEN
        )
    }
}