package com.teamb.runningtracker.domain.usecase.userdetail

import com.teamb.runningtracker.common.Extensions.toUserDetailUiModel
import com.teamb.runningtracker.data.repository.UserDetailRepository
import com.teamb.runningtracker.domain.model.UserDetailUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetUserDetailUseCase @Inject constructor(
    private val userDetailRepository: UserDetailRepository
) {
    operator fun invoke(): Flow<UserDetailUiModel> {
        return userDetailRepository.getUserDetail().map {
            it.toUserDetailUiModel()
        }
    }
}