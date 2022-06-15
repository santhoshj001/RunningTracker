package com.teamb.runningtracker.presentation.InsightsScreen

import androidx.lifecycle.ViewModel
import com.teamb.runningtracker.domain.usecase.runstatistics.RunStatisticsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RunStatisticsViewModel @Inject constructor(
    private val runStatisticsUseCase: RunStatisticsUseCase
) : ViewModel() {
}