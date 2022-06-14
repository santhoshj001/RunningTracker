package com.teamb.runningtracker.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.teamb.runningtracker.presentation.WelcomeScreen
import com.teamb.runningtracker.presentation.common.Screen


@Composable
fun SetUpNavGraph(
    navHostController: NavHostController,
    startDestination: String
) {
    NavHost(navController = navHostController, startDestination = startDestination) {
        composable(Screen.WelcomeScreen.route) {
            WelcomeScreen(navHostController)
        }

        composable(Screen.HomeScreen.route) {

        }

    }


}