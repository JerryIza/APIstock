package com.example.composetdaapp.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
/*
private val launchWebScreen = mutableStateOf(false)


@ExperimentalAnimationApi
@Composable
fun Navigation(
    //startDestination: String = Screen.Login.route
) {


    val navController = rememberNavController()

    //val actions = remember(navController) { MainActions(navController) }

    NavHost(navController = navController, startDestination = Screen.Login.route) {


        composable(route = Screen.Login.route) {
            LoginScreen(onClick = { { /*TODO*/ } }, navController = navController)
        }

        composable(Screen.Home.route) {
            DashboardScreen()

        }
    }
}
*/

/*class MainActions(navController: NavController) {

    val detailScreen: (String) -> Unit = { noteId: String ->
        navController.currentBackStackEntry?.arguments?.putString(
            LOGIN,
            noteId
        )
        navController.navigate(Screen.NoteDetail.route)
    }
    val addScreen: (Note) -> Unit = { note: Note ->
        navController.currentBackStackEntry?.arguments?.putString(
            NOTE_ID,
            note.noteId
        )
        navController.navigate(Screen.AddNote.route)
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
    val mainScreen: () -> Unit = {
        navController.navigate(Screen.Login.route) {
            popUpTo(0) { inclusive = true }
        }
    }
}*/
