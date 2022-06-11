package com.teamb.runningtracker.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.teamb.runningtracker.common.Constants

@Entity(tableName = Constants.TABLE_NAME)
data class RunEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var image: String? = null,
    val timeStamp: Long = 0L,
    val timeInMillis: Long = 0L,
    val avgSpeedInKMPH: Float = 0f,
    val distanceInMeters: Float = 0f,
    val caloriesBurned: Int = 0
)
