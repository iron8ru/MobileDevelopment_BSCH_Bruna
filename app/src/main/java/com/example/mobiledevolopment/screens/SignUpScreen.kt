package com.example.mobiledevolopment.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mobiledevolopment.Components.CheckboxComponent
import com.example.mobiledevolopment.Components.DividerTextComponent
import com.example.mobiledevolopment.Components.HeadingTextComponent
import com.example.mobiledevolopment.Components.LoginTextFieldComponent
import com.example.mobiledevolopment.Components.RegisterButtonComponent
import com.example.mobiledevolopment.Components.TextComponent
import com.example.mobiledevolopment.R


@Composable
fun SignUpScreen(navController: NavHostController) {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        )
        {

            Spacer(modifier = Modifier.size(20.dp))
            HeadingTextComponent("Create an Account")
            Spacer(modifier = Modifier.size(20.dp))
            LoginTextFieldComponent(
                "First Name",
                painterResource(id = R.drawable.profile)
            )
            LoginTextFieldComponent(
                "Last Name",
                painterResource(id = R.drawable.profile)
            )
            LoginTextFieldComponent(
                "Email",
                painterResource(id = R.drawable.email)
            )
            LoginTextFieldComponent(
                "Password",
                painterResource(id = R.drawable.password)
            )

            CheckboxComponent(value = "By clicking here I accept terms and conditions")

            Spacer(modifier = Modifier.height(100.dp))

            RegisterButtonComponent("Register") {
                navController.navigate(Routes.USER_INPUT_SCREEN)
            }
            Spacer(modifier = Modifier.height(20.dp))
            DividerTextComponent()
            TextComponent("Already have an account? Login", textSize = 18.sp, paddingStart = 24.dp, onTextClicked = {
                navController.navigate(Routes.SIGN_IN_SCREEN) {
                    popUpTo(Routes.SIGN_UP_SCREEN){
                        inclusive = true
                    }
                }
            })




        }
    }

}

@Preview
@Composable

fun SignUpScreenPreview() {
    val navController = rememberNavController() // Create an instance of UserInputViewModel
    SignUpScreen(navController)
}