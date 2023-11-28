package com.example.mobiledevolopment.ui.screens.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobiledevolopment.R
import com.example.mobiledevolopment.navigation.ActivityType
import com.example.mobiledevolopment.theme.BgColor
import com.example.mobiledevolopment.theme.Primary
import com.example.mobiledevolopment.theme.componentShapes


@Composable
fun TopBar(value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = value,
            color = Color.Black,
            fontSize = 28.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.bulb),
            contentDescription = "lamp Bulb",

            )

    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar("")
}

@Composable
fun TextComponent(
    textValue: String,
    textSize: TextUnit,
    colorValue: Color = Color.Black,
    paddingStart: Dp = 0.dp,
    onTextClicked: () -> Unit = {}
) {

    Text(
        text = textValue,
        fontSize = textSize,
        color = colorValue,
        fontWeight = FontWeight.Light,
        modifier = Modifier
            .padding(paddingValues = PaddingValues(start = paddingStart))
            .clickable {
                onTextClicked()
            }
    )

}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 80.dp),
        style = TextStyle(
            fontSize = 30.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold
        ), color = colorResource(id = R.color.colorBlack),
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview() {
    TextComponent(textValue = "I Hate Jetpack", textSize = 24.sp)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(
    labelValue: String, onTextChanged: (name: String) -> Unit
) {
    var currentValue by remember {
        mutableStateOf("")
    }

    val localFocusManager = LocalFocusManager.current
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,


            ),
        value = currentValue,
        onValueChange = {
            currentValue = it
            onTextChanged(it)

        },
        placeholder = {
            Text(text = "Enter your name", fontSize = 18.sp)
        },
        textStyle = TextStyle.Default.copy(fontSize = 24.sp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        }

    )
    //)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextFieldComponent(
    labelValue: String, painterResource: Painter
) {
    val password = remember {
        mutableStateOf("")
    }


    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.large)
            .background(BgColor),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary

        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = password.value,
        onValueChange = {
            password.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")

        },

        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTextFieldComponent(
    labelValue: String, painterResource: Painter,
    onTextChanged: (name: String) -> Unit
) {
    val textValue = remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.large)
            .background(BgColor),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary

        ),
        keyboardOptions = KeyboardOptions.Default,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
            onTextChanged(it)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")

        }
    )
}

@Composable
fun CheckboxComponent(value: String, onCheckBoxChanged: (Boolean) ->Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically,
    )
    {
        val checkedState = remember {
            mutableStateOf(false)
        }

        Checkbox(checked = checkedState.value, onCheckedChange = {
            checkedState.value = !checkedState.value
            onCheckBoxChanged(checkedState.value)
        })

        TextComponent(textValue = value, textSize = 15.sp)


    }
}

@Composable
fun ActivityCard(image: Int, selected: Boolean, cardSelected: (activityType: ActivityType) -> Unit) {

    val localFocusManager = LocalFocusManager.current

    Card(
        modifier = Modifier
            .padding(24.dp)
            .size(130.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = if (selected) Color.Green else Color.Transparent,
                    shape = RoundedCornerShape(15.dp)
                )
                .clickable {
                    val cardName = when (image) {
                        R.drawable.readbook150 -> ActivityType.READ
                        R.drawable.findcat150 -> ActivityType.CAT
                        R.drawable.gonap150 -> ActivityType.NAP
                        R.drawable.stars300 -> ActivityType.STARS
                        else -> {ActivityType.UNKNOWN}
                    }
                    cardSelected(cardName)
                    localFocusManager.clearFocus()
                }
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(id = image),
                contentDescription = "card image"
            )
        }
    }
}

@Composable
fun ButtonComponent(
    goToAdviseScreen: () -> Unit
) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            goToAdviseScreen()
        }) {
        TextComponent(textValue = "Advise me", textSize = 18.sp, colorValue = Color.White)
    }
}

@Composable
fun RegisterButtonComponent(
    value: String,
    onClickListener: () -> Unit
) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            onClickListener()
        }) {
        Text(text = value, color = Color.White, fontSize = 18.sp)
    }
}

@Composable
fun DividerTextComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = Color.Gray,
            thickness = 1.dp
        )


        Text(text = "or", modifier = Modifier.padding(8.dp), fontSize = 18.sp)

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = Color.Gray,
            thickness = 1.dp
        )

    }
}

@Composable
fun TextWithShadow(value: String,
                   textSize: TextUnit,
                   textAlign: TextAlign?,
                   modifier: Modifier = Modifier,
                   colorValue: Color = Color.White){
    val shadowOffset = Offset(x= 1f, y=2f)
    Text(
        text = value,
        color = colorValue,
        fontSize = textSize,

        style = TextStyle(
            shadow = Shadow(color = colorValue, shadowOffset, 2f)
        ),
        fontWeight = FontWeight.Light,
    )

}
@Composable
fun AdviseComposable(
    roomLight: String,
    lightAction: String,
    image: Int,
    cardBackground: Color,
    textColor: Color
){ // make background color a parameter too
    Card( modifier = Modifier
        .padding(25.dp)
        .fillMaxWidth()
        .fillMaxHeight(),
        shape =RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(cardBackground)
    ){
        Column (
            modifier = Modifier.padding(18.dp,24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Image(painter = painterResource(id = R.drawable.bulb), contentDescription = "quoteImage", alignment = Alignment.Center)
            Spacer(modifier = Modifier.size(45.dp))
            TextWithShadow(value = roomLight, 30.sp, textAlign = TextAlign.Center, colorValue = textColor)
            Spacer(modifier = Modifier.size(80.dp))
            TextWithShadow(value = lightAction, 20.sp, textAlign = TextAlign.Center, colorValue = textColor)
            Spacer(modifier = Modifier.size(80.dp))
            Image(painter = painterResource(id = image), contentDescription = "quoteImage", alignment = Alignment.Center)

        }

    }
}

@Preview
@Composable
fun AdviseComposablePreview(){
    AdviseComposable(
        "TEST",
        "another test",
        image = R.drawable.cat3_reduce,
        cardBackground = Color.DarkGray,
        textColor = Color.White
    )
}


