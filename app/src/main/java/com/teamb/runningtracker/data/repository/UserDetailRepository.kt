package com.teamb.runningtracker.data.repository

import com.teamb.runningtracker.UserDetail
import kotlinx.coroutines.flow.Flow

interface UserDetailRepository {
    fun getUserDetail(): Flow<UserDetail>
    suspend fun setUserDetail(userDetail: UserDetail)
}