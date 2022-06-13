package com.teamb.runningtracker.presentation.authScreen

sealed class AuthScreenEvent() {
    object OnSubmit : AuthScreenEvent()
}
