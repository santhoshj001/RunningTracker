package com.teamb.runningtracker.domain.usecase.userdetail

import com.teamb.runningtracker.common.Extensions.toUserDetail
import com.teamb.runningtracker.data.repository.UserDetailRepository
import com.teamb.runningtracker.domain.model.UserDetailUiModel
import javax.inject.Inject

class SaveUserDetailUseCase @Inject constructor(
    private val userDetailRepository: UserDetailRepository
) {
    suspend fun saveUSerDetail(userDetailUiModel: UserDetailUiModel) {
        userDetailRepository.setUserDetail(userDetailUiModel.toUserDetail())
    }
}

