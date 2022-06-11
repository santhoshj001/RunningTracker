package com.teamb.runningtracker.domain.usecase.runlist

data class RunListUseCase(
    val getRunsByDistanceUseCase: GetRunsByDistanceUseCase,
    val getRunsByTimeInMillisUseCase: GetRunsByTimeInMillisUseCase,
    val getRunsByTimeStampUseCase: GetRunsByTimeStampUseCase,
    val getRunsByAvgSpeedUseCase: GetRunsByAvgSpeedUseCase,
    val getRunsByCaloriesUseCase: GetRunsByCaloriesUseCase
)