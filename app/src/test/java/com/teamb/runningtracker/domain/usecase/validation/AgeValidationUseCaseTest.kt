package com.teamb.runningtracker.domain.usecase.validation

import org.junit.Test

class AgeValidationUseCaseTest {

    @Test
    fun `validate age when empty string`() {
        val useCase = AgeValidationUseCase()
        val result = useCase.invoke("")
        assert(!result.isSuccess)
    }

    @Test
    fun `validate age when 0`() {
        val useCase = AgeValidationUseCase()
        val result = useCase.invoke("0")
        assert(!result.isSuccess)
    }

    @Test
    fun `validate age when 101`() {
        val useCase = AgeValidationUseCase()
        val result = useCase.invoke("101")
        assert(!result.isSuccess)
    }

    @Test
    fun `validate age when valid`() {
        val useCase = AgeValidationUseCase()
        val result = useCase.invoke("10")
        assert(result.isSuccess)
    }

    @Test
    fun `validate age when non number String`() {
        val useCase = AgeValidationUseCase()
        val result = useCase.invoke("10.1")
        assert(!result.isSuccess)
    }

    @Test
    fun `validate age when random String`() {
        val useCase = AgeValidationUseCase()
        val result = useCase.invoke("abc")
        assert(!result.isSuccess)
    }

}