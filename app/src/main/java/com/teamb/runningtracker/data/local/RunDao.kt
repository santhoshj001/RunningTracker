package com.teamb.runningtracker.data.local

import androidx.room.*
import com.teamb.runningtracker.common.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface RunDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: RunEntity)

    @Delete
    suspend fun deleteRun(run: RunEntity)

    @Query("SELECT  * FROM ${Constants.TABLE_NAME} ORDER BY timeStamp DESC")
    fun getRunsByTimeStamp(): Flow<List<RunEntity>>

    @Query("SELECT  * FROM ${Constants.TABLE_NAME} ORDER BY timeInMillis DESC")
    fun getRunsByTimeInMillis(): Flow<List<RunEntity>>

    @Query("SELECT  * FROM ${Constants.TABLE_NAME} ORDER BY avgSpeedInKMPH DESC")
    fun getRunsByAvgSpeed(): Flow<List<RunEntity>>

    @Query("SELECT  * FROM ${Constants.TABLE_NAME} ORDER BY distanceInMeters DESC")
    fun getRunsByDistance(): Flow<List<RunEntity>>

    @Query("SELECT  * FROM ${Constants.TABLE_NAME} ORDER BY caloriesBurned DESC")
    fun getRunsByCaloriesBurned(): Flow<List<RunEntity>>

    @Query("SELECT  SUM(timeStamp)  FROM ${Constants.TABLE_NAME}")
    fun getTotalTimeInMillis(): Flow<Long>

    @Query("SELECT  AVG(avgSpeedInKMPH)  FROM ${Constants.TABLE_NAME}")
    fun getTotalAvgSpeedInKMPH(): Flow<Long>

    @Query("SELECT  SUM(distanceInMeters)  FROM ${Constants.TABLE_NAME}")
    fun getTotalDistance(): Flow<Long>

    @Query("SELECT  SUM(caloriesBurned)  FROM ${Constants.TABLE_NAME}")
    fun getTotalCaloriesBurned(): Flow<Long>
}