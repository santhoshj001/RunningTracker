package com.teamb.runningtracker.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamb.runningtracker.domain.usecase.SplashScreenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val splashScreenUseCase: SplashScreenUseCase
) : ViewModel() {

    var isLoading by mutableStateOf(true)
        private set

    init {
        viewModelScope.launch {


            delay(1000)
            isLoading = false

        }
    }

    fun updatedOnBoardingCompleted() {
        viewModelScope.launch {
            splashScreenUseCase.setIsOnBoardingCompleted(true)
        }
    }
}