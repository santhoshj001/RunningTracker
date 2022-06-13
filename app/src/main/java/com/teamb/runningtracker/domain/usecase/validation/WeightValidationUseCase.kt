package com.teamb.runningtracker.domain.usecase.validation

import com.teamb.runningtracker.common.ValidationResult

class WeightValidationUseCase {
    operator fun invoke(weight: String): ValidationResult {
        if (weight.isBlank()) {
            return ValidationResult(false, "enter a valid number")
        }
        if (weight.toFloatOrNull() == null) {
            return ValidationResult(false, " Enter a valid number ")
        }
        if (weight.toFloat() < 1) {
            return ValidationResult(false, " Enter a valid weight greater than 0 ")
        }
        return ValidationResult(true)
    }
}