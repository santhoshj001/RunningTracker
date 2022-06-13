package com.teamb.runningtracker.presentation.AddUserDetailScreen

data class AddUserDetailScreenState(
    val firstName: String = "",
    val lastName: String = "",
    val age: String = "0",
    val weight: String = "0",
    val firstNameError: String? = null,
    val lastNameError: String? = null,
    val ageError: String? = null,
    val weightError: String? = null,
)
