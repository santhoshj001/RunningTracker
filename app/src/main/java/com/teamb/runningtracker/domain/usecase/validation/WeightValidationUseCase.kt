package com.teamb.runningtracker.domain.usecase.validation

import com.teamb.runningtracker.common.ValidationResult

class WeightValidationUseCase {
    operator fun invoke(weight: String): ValidationResult {
        if (weight.any { !it.isDigit() }) {
            return ValidationResult(false, " Enter a valid number ")
        }
        if (weight.toInt() < 1) {
            return ValidationResult(false, " Enter a valid weight greater than 0 ")
        }
        return ValidationResult(true)
    }
}