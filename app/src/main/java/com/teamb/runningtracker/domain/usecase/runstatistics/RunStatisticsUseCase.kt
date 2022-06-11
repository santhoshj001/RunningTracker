package com.teamb.runningtracker.domain.usecase.runstatistics

data class RunStatisticsUseCase(
    val getTotalDistanceUseCase: GetTotalDistanceCoveredUseCase,
    val getTotalTimeInMillisUseCase: GetTotalTimeInMillisUseCase,
    val getTotalCaloriesBurnedUseCase: GetTotalCaloriesBurnedUseCase,
    val getTotalAvgSpeedUseCase: GetTotalAvgSpeedUseCase
)
