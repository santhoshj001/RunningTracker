package com.teamb.runningtracker.domain.usecase

import com.teamb.runningtracker.data.repository.SplashRepository
import javax.inject.Inject

class SplashScreenUseCase @Inject constructor(
    private val splashRepository: SplashRepository
) {

    suspend fun setIsOnBoardingCompleted(isSaved: Boolean) =
        splashRepository.saveIsCompleted(isSaved)


    fun getIsOnBoardingCompleted() =
        splashRepository.getIsCompleted()

}