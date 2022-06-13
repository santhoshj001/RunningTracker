package com.teamb.runningtracker.domain.usecase.validation

import org.junit.Test

class WeightValidationUseCaseTest {
    @Test
    fun `validate Weight when empty string`() {
        val useCase = WeightValidationUseCase()
        val result = useCase.invoke("")
        assert(!result.isSuccess)
    }

    @Test
    fun `validate Weight when 0`() {
        val useCase = WeightValidationUseCase()
        val result = useCase.invoke("0")
        assert(!result.isSuccess)
    }

    @Test
    fun `validate Weight when 101`() {
        val useCase = WeightValidationUseCase()
        val result = useCase.invoke("101")
        assert(result.isSuccess)
    }

    @Test
    fun `validate Weight when valid`() {
        val useCase = WeightValidationUseCase()
        val result = useCase.invoke("10")
        assert(result.isSuccess)
    }

    @Test
    fun `validate Weight when non number String`() {
        val useCase = WeightValidationUseCase()
        val result = useCase.invoke("10.1")
        assert(result.isSuccess)
    }

    @Test
    fun `validate Weight when random String`() {
        val useCase = WeightValidationUseCase()
        val result = useCase.invoke("abc")
        assert(!result.isSuccess)
    }
}