package com.teamb.runningtracker.presentation.common


sealed class Screen(val route: String) {
    object RunScreen : Screen("run_screen")
    object StatisticsScreen : Screen("statistics_screen")
    object UserDetailScreen : Screen("user_detail_screen")
}