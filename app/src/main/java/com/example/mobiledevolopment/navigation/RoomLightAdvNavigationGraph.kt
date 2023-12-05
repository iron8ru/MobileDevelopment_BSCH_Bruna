package com.example.mobiledevolopment.navigation


import SignUpScreen
import android.os.Build
import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mobiledevolopment.ui.screens.advicescreen.AdviseScreen
import com.example.mobiledevolopment.ui.screens.authentication.SignInScreen
import com.example.mobiledevolopment.ui.screens.userinput.UserInputViewModel
import com.example.mobiledevolopment.ui.screens.userinput.UserInPutScreen
import kotlinx.parcelize.Parcelize

@Composable
fun RoomLightAdvNavigationGraph(userInputViewModel: UserInputViewModel = viewModel()) {
    val navController = rememberNavController()

    // for start we need to define the first screen as string we want on the application
    NavHost(navController = navController, startDestination = Routes.SIGN_IN_SCREEN) {

        composable(Routes.SIGN_UP_SCREEN) {
            SignUpScreen(navController)
        }

        composable(Routes.SIGN_IN_SCREEN) {
            SignInScreen(navController)
        }

        composable(Routes.USER_INPUT_SCREEN) {
            UserInPutScreen(userInputViewModel, showMeAdviseScreen = {
                println("Coming_inside_AdviseScreen")
                println(it.first)
                println(it.second)
                navController.navigate(Routes.ADVISE_SCREEN +"/${it.first}/${it.second}")
            })
        }

        composable("${Routes.ADVISE_SCREEN}/{${Routes.USER_NAME}}/{${Routes.CARD_SELECTED}}",
        arguments = listOf(
            navArgument(name = Routes.USER_NAME){ type =NavType.StringType},
            navArgument(name = Routes.CARD_SELECTED){ type = NavType.EnumType(ActivityType::class.java)}
        )) {
            val username = it.arguments?.getString(Routes.USER_NAME)
            val cardSelected = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.arguments?.getParcelable(Routes.CARD_SELECTED, ActivityType::class.java)
            } else {
                @Suppress("DEPRECATION")
                it.arguments?.getParcelable(Routes.CARD_SELECTED)
            }?: ActivityType.UNKNOWN
            AdviseScreen(username, cardSelected)
        }
    }
}

@Parcelize
enum class ActivityType : Parcelable {
    READ, NAP, CAT, STARS, UNKNOWN
}

