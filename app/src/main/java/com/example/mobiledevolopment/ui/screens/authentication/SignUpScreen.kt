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
import com.example.mobiledevolopment.R
import com.example.mobiledevolopment.navigation.Routes
import com.example.mobiledevolopment.util.Resource
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobiledevolopment.ui.screens.authentication.AuthenticationViewModel
import com.example.mobiledevolopment.ui.screens.theme.CheckboxComponent
import com.example.mobiledevolopment.ui.screens.theme.DividerTextComponent
import com.example.mobiledevolopment.ui.screens.theme.HeadingTextComponent
import com.example.mobiledevolopment.ui.screens.theme.LoginTextFieldComponent
import com.example.mobiledevolopment.ui.screens.theme.RegisterButtonComponent
import com.example.mobiledevolopment.ui.screens.theme.TextComponent


@Composable
fun SignUpScreen(navController: NavHostController, viewModel: AuthenticationViewModel = viewModel()) {
    val context = LocalContext.current
    val uiState = viewModel.uiState.collectAsState()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var terms by remember { mutableStateOf(false) }
    //main layout for the SignUpScreen
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
            HeadingTextComponent(stringResource(R.string.create_an_account))
            Spacer(modifier = Modifier.size(20.dp))
            // input field for email
            LoginTextFieldComponent(
                stringResource(R.string.email),
                painterResource(id = R.drawable.email),
                onTextChanged = {
                    email = it
                }
            )
            // input field for password
            LoginTextFieldComponent(
                stringResource(R.string.password),
                painterResource(id = R.drawable.password), onTextChanged = {
                    password = it
                }
            )

            CheckboxComponent(
                value = stringResource(R.string.by_clicking_here_i_accept_terms_and_conditions),
                onCheckBoxChanged = {
                    terms = it
                })

            Spacer(modifier = Modifier.height(100.dp))

            RegisterButtonComponent(stringResource(R.string.register)) {
                if (email.isEmpty()) {
                    Toast.makeText(
                        context,
                        "Email is empty",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (password.isEmpty()) {
                    Toast.makeText(
                        context,
                        "Password is empty",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (!terms) {
                    Toast.makeText(
                        context,
                        "Please accept the terms and conditions to proceed",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    viewModel.register(email, password)
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            DividerTextComponent()
            TextComponent(
                stringResource(R.string.already_have_an_account_login),
                textSize = 18.sp,
                paddingStart = 24.dp,
                onTextClicked = {
                    navController.navigate(Routes.SIGN_IN_SCREEN) {
                        popUpTo(Routes.SIGN_UP_SCREEN) {
                            inclusive = true
                        }
                    }
                })

        }
    }
    //toasts and loading indicators
    when (uiState.value) {
        is Resource.Error -> {
            Toast.makeText(context,
                stringResource(R.string.failed_to_register_your_email, email), Toast.LENGTH_SHORT)
                .show()
        }

        is Resource.Loading -> {
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
            Toast.makeText(context,
                stringResource(R.string.registered_successfully), Toast.LENGTH_SHORT).show()
            navController.navigate(Routes.USER_INPUT_SCREEN)
        }

        else -> {}
    }

}

@Preview
@Composable

fun SignUpScreenPreview() {
    val navController = rememberNavController() // Create an instance of UserInputViewModel
    SignUpScreen(navController)
}