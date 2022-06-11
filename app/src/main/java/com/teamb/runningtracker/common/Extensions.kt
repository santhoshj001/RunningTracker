package com.teamb.runningtracker.common

import com.teamb.runningtracker.data.local.RunEntity
import com.teamb.runningtracker.domain.model.RunUiModel

object Extensions {

    fun RunEntity.toRunUiModel(): RunUiModel {
        return RunUiModel(
            id = id,
            image = image,
            timeStamp = timeStamp,
            timeInMillis = timeInMillis,
            avgSpeedInKMPH = avgSpeedInKMPH,
            distanceInMeters = distanceInMeters,
            caloriesBurned = caloriesBurned
        )
    }

}