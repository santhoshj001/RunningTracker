package com.teamb.runningtracker.presentation.statisticsscreen

import androidx.lifecycle.ViewModel
import com.teamb.runningtracker.domain.usecase.runstatistics.RunStatisticsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RunStatisticsViewModel @Inject constructor(
    runStatisticsUseCase: RunStatisticsUseCase
) : ViewModel() {
}