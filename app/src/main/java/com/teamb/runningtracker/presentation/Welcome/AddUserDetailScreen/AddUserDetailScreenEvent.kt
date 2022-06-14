package com.teamb.runningtracker.presentation.Welcome.AddUserDetailScreen

sealed class AddUserDetailScreenEvent() {
    data class OnFirstNameChange(val firstName: String) : AddUserDetailScreenEvent()
    data class OnLastNameChange(val lastName: String) : AddUserDetailScreenEvent()
    data class OnAgeChange(val age: String) : AddUserDetailScreenEvent()
    data class OnWeightChange(val weight: String) : AddUserDetailScreenEvent()
    object OnSubmit : AddUserDetailScreenEvent()
}
