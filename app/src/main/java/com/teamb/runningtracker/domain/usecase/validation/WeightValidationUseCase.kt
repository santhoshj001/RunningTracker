package com.teamb.runningtracker.domain.usecase.validation

import com.teamb.runningtracker.common.ValidationResult

class WeightValidationUseCase {
    operator fun invoke(weight: Int): ValidationResult {
        if (weight < 0) {
            return ValidationResult(false, " Weight needs to be greater than 0")
        }
        return ValidationResult(true)
    }
}