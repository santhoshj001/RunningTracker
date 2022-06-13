package com.teamb.runningtracker.domain.usecase.validation

import com.teamb.runningtracker.common.ValidationResult

class AgeValidationUseCase {
    operator fun invoke(age: String): ValidationResult {
        if (age.any { !it.isDigit() }) {
            return ValidationResult(false, "enter a valid number")
        }
        if (age.toInt() !in 1..100) {
            return ValidationResult(false, " Enter a valid number between 1 and 99 ")
        }
        return ValidationResult(true)
    }
}