package com.teamb.runningtracker.domain.usecase.validation

import org.junit.Test

class LastNameValidationUseCaseTest {

    @Test
    fun `validate last name when empty string`() {
        val useCase = LastNameValidationUseCase()
        val result = useCase.invoke("")
        assert(!result.isSuccess)
    }

    @Test
    fun `validate last name when non empty string`() {
        val useCase = LastNameValidationUseCase()
        val result = useCase.invoke("abc")
        assert(result.isSuccess)
    }
}