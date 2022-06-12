package com.teamb.runningtracker.presentation.runlistscreen

import androidx.lifecycle.ViewModel
import com.teamb.runningtracker.domain.usecase.runlist.RunListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class RunListViewModel @Inject constructor(
    private val runListUseCase: RunListUseCase
) : ViewModel() {
}