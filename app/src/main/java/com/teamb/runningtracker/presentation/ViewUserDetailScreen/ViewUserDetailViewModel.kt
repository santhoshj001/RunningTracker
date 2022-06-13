package com.teamb.runningtracker.presentation.ViewUserDetailScreen

import androidx.lifecycle.ViewModel
import com.teamb.runningtracker.domain.usecase.runstatistics.RunStatisticsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewUserDetailViewModel @Inject constructor(
    private val useCase: RunStatisticsUseCase
) : ViewModel() {
}