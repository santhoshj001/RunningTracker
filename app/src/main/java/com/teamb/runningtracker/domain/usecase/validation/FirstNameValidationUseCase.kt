package com.teamb.runningtracker.domain.usecase.validation

import com.teamb.runningtracker.common.ValidationResult

class FirstNameValidationUseCase {
    operator fun invoke(firstName: String): ValidationResult {
        if (firstName.isBlank()) {
            return ValidationResult(false, "FirstName can't be blank")
        }
        return ValidationResult(true)
    }
}