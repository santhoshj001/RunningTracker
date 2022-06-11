package com.teamb.runningtracker.domain.repository

import com.teamb.runningtracker.data.local.RunDao
import com.teamb.runningtracker.data.local.RunEntity
import com.teamb.runningtracker.data.repository.RunLocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RunLocalRepositoryImpl @Inject constructor(
    private val dao: RunDao
) : RunLocalRepository {

    override suspend fun insertRun(run: RunEntity) {
        dao.insertRun(run)
    }

    override suspend fun deleteRun(run: RunEntity) {
        dao.deleteRun(run)
    }

    override fun getRunsByTimeStamp(): Flow<List<RunEntity>> {
        return dao.getRunsByTimeStamp()
    }

    override fun getRunsByTimeInMillis(): Flow<List<RunEntity>> {
        return dao.getRunsByTimeStamp()
    }

    override fun getRunsByAvgSpeed(): Flow<List<RunEntity>> {
        return dao.getRunsByAvgSpeed()
    }

    override fun getRunsByDistance(): Flow<List<RunEntity>> {
        return dao.getRunsByDistance()
    }

    override fun getRunsByCaloriesBurned(): Flow<List<RunEntity>> {
        return dao.getRunsByCaloriesBurned()
    }

    override fun getTotalTimeInMillis(): Flow<Long> {
        return dao.getTotalTimeInMillis()
    }

    override fun getTotalAvgSpeedInKMPH(): Flow<Long> {
        return dao.getTotalAvgSpeedInKMPH()
    }

    override fun getTotalDistance(): Flow<Long> {
        return dao.getTotalDistance()
    }

    override fun getTotalCaloriesBurned(): Flow<Long> {
        return dao.getTotalCaloriesBurned()
    }
}