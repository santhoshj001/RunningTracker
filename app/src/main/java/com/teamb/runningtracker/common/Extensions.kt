package com.teamb.runningtracker.common

import com.teamb.runningtracker.UserDetail
import com.teamb.runningtracker.data.local.RunEntity
import com.teamb.runningtracker.domain.model.RunUiModel
import com.teamb.runningtracker.domain.model.UserDetailUiModel

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

    fun UserDetailUiModel.toUserDetail(): UserDetail {
        return UserDetail.getDefaultInstance().toBuilder()
            .setFirstName(this.firstName)
            .setLastName(this.lastName)
            .setLastName(this.lastName)
            .setAge(this.age)
            .build()
    }

    fun UserDetail.toUserDetailUiModel(): UserDetailUiModel {
        return UserDetailUiModel(
            firstName = this.firstName,
            lastName = this.lastName,
            age = this.age,
            weight = this.weight
        )
    }
}