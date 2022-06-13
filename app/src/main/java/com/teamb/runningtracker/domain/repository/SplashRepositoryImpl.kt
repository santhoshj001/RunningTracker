package com.teamb.runningtracker.domain.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.teamb.runningtracker.common.Constants
import com.teamb.runningtracker.data.repository.SplashRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SplashRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : SplashRepository {
    override suspend fun saveIsCompleted(isSaved: Boolean) {
        dataStore.edit {
            it[Constants.IS_ON_BOARDING_COMPLETED] = isSaved
        }
    }

    override fun getIsCompleted(): Flow<Boolean> = dataStore.data.map {
        it[Constants.IS_ON_BOARDING_COMPLETED] ?: false
    }
}