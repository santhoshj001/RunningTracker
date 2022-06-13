package com.teamb.runningtracker.domain.repository

import androidx.datastore.core.DataStore
import com.teamb.runningtracker.UserDetail
import com.teamb.runningtracker.data.repository.UserDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserDetailRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<UserDetail>
) : UserDetailRepository {
    override fun getUserDetail(): Flow<UserDetail> {
        return dataStore.data
    }

    override suspend fun setUserDetail(userDetail: UserDetail) {
        dataStore.updateData { current ->
            current.toBuilder()
                .setFirstName(userDetail.firstName)
                .setLastName(userDetail.lastName)
                .setAge(userDetail.age)
                .setWeight(userDetail.weight)
                .build()
        }
    }
}