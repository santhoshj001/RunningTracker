package com.teamb.runningtracker.presentation.Welcome.AddUserDetailScreen

sealed class ScreenEvent {
    data class Navigate(val route: String) : ScreenEvent()
}
