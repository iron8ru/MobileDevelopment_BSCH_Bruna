package com.example.mobiledevolopment.ui.screens.authentication

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mobiledevolopment.ui.screens.theme.DividerTextComponent
import com.example.mobiledevolopment.ui.screens.theme.HeadingTextComponent
import com.example.mobiledevolopment.ui.screens.theme.LoginTextFieldComponent
import com.example.mobiledevolopment.ui.screens.theme.RegisterButtonComponent
import com.example.mobiledevolopment.ui.screens.theme.TextComponent
import com.example.mobiledevolopment.R
import com.example.mobiledevolopment.navigation.Routes
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobiledevolopment.util.Resource


@Composable
fun SignInScreen(navController: NavHostController, viewModel: AuthenticationViewModel = viewModel()) {
    val context = LocalContext.current
    val uiState = viewModel.uiState.collectAsState()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    // Main layout of the sign-in screen
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

            Spacer(modifier = Modifier.height(20.dp))
            HeadingTextComponent(stringResource(R.string.welcome))
            Spacer(modifier = Modifier.size(20.dp))
            // Input field for the username
            LoginTextFieldComponent(
                "Username",
                painterResource(id = R.drawable.profile), onTextChanged = {
                    email = it
                }
            )
            // Input field for the password
            LoginTextFieldComponent(
                "Password",
                painterResource(id = R.drawable.password), onTextChanged = {
                    password = it
                }
            )
            Spacer(modifier = Modifier.height(20.dp))

            TextComponent(stringResource(R.string.forgot_your_password_reset), textSize = 13.sp,  paddingStart = 70.dp)

            Spacer(modifier = Modifier.height(100.dp))

            RegisterButtonComponent(stringResource(R.string.login)) {
                viewModel.login(email, password)

            }
            Spacer(modifier = Modifier.height(20.dp))
            DividerTextComponent()
            Spacer(modifier = Modifier.height(20.dp))
            // Display a link for user registration
            TextComponent(stringResource(R.string.doesn_t_have_an_account_sign_up), textSize = 18.sp,  paddingStart = 20.dp, onTextClicked = {
                navController.navigate(Routes.SIGN_UP_SCREEN){
                    popUpTo(Routes.SIGN_IN_SCREEN){
                        inclusive = true
                    }
                }
            })

        }
    }

    //toasts and loading indicators
    when (uiState.value) {
        is Resource.Error -> {
            // Display a toast for authentication error
            Toast.makeText(context,
                stringResource(R.string.username_and_password_are_not_matching), Toast.LENGTH_SHORT)
                .show()
        }

        is Resource.Loading -> {
            // Display a loading indicator
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(8.dp),
                    color = colorResource(id = R.color.purple_500)
                )
            }
        }

        is Resource.Success -> {
            // Display a success toast and navigate to the next screen
            Toast.makeText(context, stringResource(R.string.login_successfully), Toast.LENGTH_SHORT).show()
            navController.navigate(Routes.USER_INPUT_SCREEN)
        }

        else -> {}
    }

}
