package com.teamb.runningtracker.presentation.HomeScreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.Insights
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.teamb.runningtracker.presentation.common.Screen

sealed class NavigationItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {

    object RunInfo :
        NavigationItem(Screen.RunScreen.route, "Run Info", Icons.Default.DirectionsRun)

    object RunInsights :
        NavigationItem(Screen.StatisticsScreen.route, "Run Insights", Icons.Default.Insights)

    object Profile :
        NavigationItem(Screen.UserDetailScreen.route, "Profile", Icons.Default.Person)

}
