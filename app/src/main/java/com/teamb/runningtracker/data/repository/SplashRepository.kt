package com.teamb.runningtracker.data.repository

import kotlinx.coroutines.flow.Flow

interface SplashRepository {
    suspend fun saveIsCompleted(isSaved: Boolean)
    fun getIsCompleted(): Flow<Boolean>
}