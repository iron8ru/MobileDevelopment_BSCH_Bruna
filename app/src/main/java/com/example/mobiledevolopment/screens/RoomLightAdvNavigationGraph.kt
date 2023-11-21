package com.example.mobiledevolopment.screens


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mobiledevolopment.ViewModel.UserInputViewModel


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
                navController.navigate(Routes.ADVISE_SCREEN+"/${it.first}/${it.second}")
            })
        }

        composable("${Routes.ADVISE_SCREEN}/{${Routes.USER_NAME}}/{${Routes.CARD_SELECTED}}",
            arguments = listOf(
                navArgument(name = Routes.USER_NAME){ type =NavType.StringType},
                navArgument(name = Routes.CARD_SELECTED){ type = NavType.StringType}
            )) {
            val username = it?.arguments?.getString(Routes.USER_NAME)
            val cardSelected = it?.arguments?.getString(Routes.CARD_SELECTED)
            AdviseScreen(username, cardSelected)
        }
    }
}
