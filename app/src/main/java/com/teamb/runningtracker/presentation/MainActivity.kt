package com.teamb.runningtracker.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.teamb.runningtracker.presentation.common.Screen
import com.teamb.runningtracker.presentation.navigation.SetUpNavGraph
import com.teamb.runningtracker.ui.theme.RunningTrackerTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().setKeepOnScreenCondition {
            splashViewModel.isLoading
        }

        setContent {
            RunningTrackerTheme {
                val navController = rememberNavController()
                SetUpNavGraph(
                    navHostController = navController,
                    startDestination = splashViewModel.startDestination
                )
            }
        }
    }
}
