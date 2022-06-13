package com.teamb.runningtracker.presentation.AuthScreen

import androidx.lifecycle.ViewModel
import com.teamb.runningtracker.domain.usecase.runstatistics.RunStatisticsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserAuthViewModel @Inject constructor(
    useCase: RunStatisticsUseCase
) : ViewModel() {

}