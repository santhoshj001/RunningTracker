package com.teamb.runningtracker.domain.usecase.validation

import com.teamb.runningtracker.common.ValidationResult

class LastNameValidationUseCase {
    operator fun invoke(lastName: String): ValidationResult {
        if (lastName.isBlank()) {
            return ValidationResult(false, "LastName can't be blank")
        }
        return ValidationResult(true)
    }
}