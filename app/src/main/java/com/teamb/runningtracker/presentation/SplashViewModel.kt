package com.teamb.runningtracker.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamb.runningtracker.domain.usecase.SplashScreenUseCase
import com.teamb.runningtracker.presentation.common.Screen
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

    var startDestination by mutableStateOf(Screen.WelcomeScreen.route)
        private set

    init {
        viewModelScope.launch {
            splashScreenUseCase.getIsOnBoardingCompleted().collect { onBoardingCompleted ->
                startDestination = if (onBoardingCompleted) {
                    Screen.HomeScreen.route
                } else {
                    Screen.WelcomeScreen.route
                }
                delay(500)
                isLoading = false
            }
        }
    }
}