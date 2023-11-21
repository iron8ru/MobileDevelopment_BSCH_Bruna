package com.example.mobiledevolopment.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobiledevolopment.Components.ActivityCard
import com.example.mobiledevolopment.Components.ButtonComponent
import com.example.mobiledevolopment.Components.TextComponent
import com.example.mobiledevolopment.Components.TextFieldComponent
import com.example.mobiledevolopment.Components.TopBar
import com.example.mobiledevolopment.R
import com.example.mobiledevolopment.ViewModel.UserInputViewModel
import com.example.mobiledevolopment.data.UserDataUiEvents


@Composable
fun UserInPutScreen(userInputViewModel: UserInputViewModel, showMeAdviseScreen: (Pair<String, String?>) -> Unit) {

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        )
        {
            TopBar("Hi There")
            TextComponent(textValue = "How are you today?", textSize = 24.sp)
            Spacer(modifier = Modifier.size(20.dp))
            TextFieldComponent("First Name", onTextChanged = {
                userInputViewModel.onEvent(UserDataUiEvents.UserNameEntered(it))
            })
            Spacer(modifier = Modifier.size(30.dp))
            TextComponent(textValue = "What activity you wish to do?", textSize = 20.sp)
            Spacer(modifier = Modifier.size(40.dp))

            //Displaying two columns side by side
            Row {
                // First Column
                Column {
                    TextComponent(
                        textValue = "Read a Book?",
                        textSize = 18.sp,
                        paddingStart = 24.dp
                    )
                    ActivityCard(image = R.drawable.readbook150, cardSelected = {
                        userInputViewModel.onEvent(
                            UserDataUiEvents.CardSelected(it)
                        )
                    }, selected = userInputViewModel.uiState.value.cardSelected == "Book")
                    TextComponent(
                        textValue = "Look for my Cat?",
                        textSize = 18.sp,
                        paddingStart = 24.dp
                    )
                    ActivityCard(image = R.drawable.findcat150, cardSelected = {
                        userInputViewModel.onEvent(
                            UserDataUiEvents.CardSelected(it)
                        )

                    }, selected = userInputViewModel.uiState.value.cardSelected == "Cat")
                }

                // Add spacing between columns if needed
                Spacer(modifier = Modifier.width(20.dp))

                // Second Column
                Column {
                    TextComponent(
                        textValue = "Take a Nap?",
                        textSize = 18.sp,
                        paddingStart = 24.dp
                    )
                    ActivityCard(image = R.drawable.gonap150, cardSelected = {
                        userInputViewModel.onEvent(
                            UserDataUiEvents.CardSelected(it)
                        )
                    }, selected = userInputViewModel.uiState.value.cardSelected == "Nap")
                    TextComponent(
                        textValue = "Look at the Stars?",
                        textSize = 18.sp,
                        paddingStart = 24.dp
                    )
                    ActivityCard(image = R.drawable.stars300, cardSelected = {
                        userInputViewModel.onEvent(
                            UserDataUiEvents.CardSelected(it)
                        )
                    }, selected = userInputViewModel.uiState.value.cardSelected == "Stars")
                }

            }
            Spacer(modifier = Modifier.weight(1f))
            if (userInputViewModel.isValidState()) {
                ButtonComponent(
                    goToAdviseScreen = {
                        println("=====coming here")
                        println("======${userInputViewModel.uiState.value.nameEntered}")
                        showMeAdviseScreen(
                            Pair(
                                userInputViewModel.uiState.value.nameEntered,
                                userInputViewModel.uiState.value.cardSelected
                            )
                        )
                    }
                )

            }
        }
    }
}



