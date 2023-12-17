package com.example.mobiledevolopment.ui.screens.userinput


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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobiledevolopment.ui.screens.theme.ActivityCard
import com.example.mobiledevolopment.ui.screens.theme.ButtonComponent
import com.example.mobiledevolopment.ui.screens.theme.TextComponent
import com.example.mobiledevolopment.ui.screens.theme.TextFieldComponent
import com.example.mobiledevolopment.ui.screens.theme.TopBar
import com.example.mobiledevolopment.R
import com.example.mobiledevolopment.data.UserDataUiEvents
import com.example.mobiledevolopment.navigation.ActivityType

@Composable
fun UserInPutScreen(userInputViewModel: UserInputViewModel, showMeAdviseScreen: (Pair<String, ActivityType>) -> Unit) {

    // main layout of the UserInputScreen
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        )
        {
            TopBar(stringResource(R.string.hi_there))
            TextComponent(textValue = stringResource(R.string.how_are_you_today), textSize = 24.sp)
            Spacer(modifier = Modifier.size(20.dp))
            TextFieldComponent(stringResource(R.string.type_in_your_first_name), onTextChanged = {
                userInputViewModel.onEvent(UserDataUiEvents.UserNameEntered(it))
            })
            Spacer(modifier = Modifier.size(30.dp))
            TextComponent(textValue = stringResource(R.string.what_activity_you_wish_to_do), textSize = 20.sp)
            Spacer(modifier = Modifier.size(40.dp))

            //Displaying two columns side by side
            Row {
                // First Column
                Column {
                    TextComponent(
                        textValue = stringResource(R.string.read_a_book),
                        textSize = 18.sp,
                        paddingStart = 24.dp
                    )
                    ActivityCard(image = R.drawable.readbook150, cardSelected = {
                        userInputViewModel.onEvent(
                            UserDataUiEvents.ActivitySelected(it)
                        )
                    }, selected = userInputViewModel.uiState.value.activitySelected == ActivityType.READ)
                    TextComponent(
                        textValue = stringResource(R.string.look_for_my_cat),
                        textSize = 18.sp,
                        paddingStart = 24.dp
                    )
                    ActivityCard(image = R.drawable.findcat150, cardSelected = {
                        userInputViewModel.onEvent(
                            UserDataUiEvents.ActivitySelected(activityType = it)
                        )

                    }, selected = userInputViewModel.uiState.value.activitySelected == ActivityType.CAT)
                }

                // Add spacing between columns
                Spacer(modifier = Modifier.width(20.dp))

                // Second Column
                Column {
                    TextComponent(
                        textValue = stringResource(R.string.take_a_nap),
                        textSize = 18.sp,
                        paddingStart = 24.dp
                    )
                    ActivityCard(image = R.drawable.nap, cardSelected = {
                        userInputViewModel.onEvent(
                            UserDataUiEvents.ActivitySelected(it)
                        )
                    }, selected = userInputViewModel.uiState.value.activitySelected == ActivityType.NAP)
                    TextComponent(
                        textValue = stringResource(R.string.look_at_the_stars),
                        textSize = 18.sp,
                        paddingStart = 24.dp
                    )
                    ActivityCard(image = R.drawable.stars300, cardSelected = {
                        userInputViewModel.onEvent(
                            UserDataUiEvents.ActivitySelected(it)
                        )
                    }, selected = userInputViewModel.uiState.value.activitySelected == ActivityType.STARS)
                }

            }
            Spacer(modifier = Modifier.weight(1f))
            // Display a button if the user input is considered valid
            if (userInputViewModel.isValidState()) {
                ButtonComponent(
                    goToAdviseScreen = {
                        showMeAdviseScreen(
                            Pair(
                                userInputViewModel.uiState.value.nameEntered,
                                userInputViewModel.uiState.value.activitySelected
                            )
                        )
                    }
                )

            }
        }
    }
}



