package com.teamb.runningtracker.domain.model

import android.graphics.Bitmap

data class RunUiModel(
    val id: Int = 0,
    var image: Bitmap? = null,
    val timeStamp: Long = 0L,
    val timeInMillis: Long = 0L,
    val avgSpeedInKMPH: Float = 0f,
    val distanceInMeters: Float = 0f,
    val caloriesBurned: Int = 0
)