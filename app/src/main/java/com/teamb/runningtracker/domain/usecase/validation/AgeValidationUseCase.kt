package com.teamb.runningtracker.domain.usecase.validation

import com.teamb.runningtracker.common.ValidationResult

class AgeValidationUseCase {
    operator fun invoke(age: Int): ValidationResult {
        if (age < 0) {
            return ValidationResult(false, "Age needs to be greater than 0")
        }
        return ValidationResult(true)
    }
}