package com.teamb.runningtracker.presentation.authScreen

sealed class AuthScreenEvent() {
    data class OnFirstNameChange(val firstName: String) : AuthScreenEvent()
    data class OnLastNameChange(val lastName: String) : AuthScreenEvent()
    data class OnAgeChange(val age: String) : AuthScreenEvent()
    data class OnWeightChange(val weight: String) : AuthScreenEvent()
    object OnSubmit : AuthScreenEvent()
}
