package com.teamb.runningtracker.data.repository

import com.teamb.runningtracker.data.local.RunEntity
import kotlinx.coroutines.flow.Flow

interface RunLocalRepository  {

    suspend fun insertRun(run: RunEntity)

    suspend fun deleteRun(run: RunEntity)

    fun getRunsByTimeStamp(): Flow<List<RunEntity>>

    fun getRunsByTimeInMillis(): Flow<List<RunEntity>>

    fun getRunsByAvgSpeed(): Flow<List<RunEntity>>

    fun getRunsByDistance(): Flow<List<RunEntity>>

    fun getRunsByCaloriesBurned(): Flow<List<RunEntity>>

    fun getTotalTimeInMillis(): Flow<Long>

    fun getTotalAvgSpeedInKMPH(): Flow<Long>

    fun getTotalDistance(): Flow<Long>

    fun getTotalCaloriesBurned(): Flow<Long>
}