package com.teamb.runningtracker.domain.usecase.validation

data class ValidationUseCase(
    val firstNameValidationUseCase: FirstNameValidationUseCase,
    val lastNameValidationUseCase: LastNameValidationUseCase,
    val ageValidationUseCase: AgeValidationUseCase,
    val weightValidationUseCase: WeightValidationUseCase
)
