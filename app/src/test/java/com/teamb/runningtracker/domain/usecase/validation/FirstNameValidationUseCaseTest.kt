package com.teamb.runningtracker.domain.usecase.validation

import org.junit.Test

class FirstNameValidationUseCaseTest {

    @Test
    fun `validate first name when empty string`() {
        val useCase = FirstNameValidationUseCase()
        val result = useCase.invoke("")
        assert(!result.isSuccess)
    }

    @Test
    fun `validate first name for valid string`() {
        val useCase = FirstNameValidationUseCase()
        val result = useCase.invoke("hello")
        assert(result.isSuccess)
    }
}