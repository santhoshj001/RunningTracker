package com.teamb.runningtracker.domain.usecase.runlist

import com.teamb.runningtracker.common.Extensions.toRunUiModel
import com.teamb.runningtracker.data.repository.RunLocalRepository
import com.teamb.runningtracker.domain.model.RunUiModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetRunsByTimeStampUseCase @Inject constructor(
    private val repository: RunLocalRepository
) {
    operator fun invoke(): Flow<List<RunUiModel>> {
        return repository.getRunsByTimeStamp().map { Runs ->
            Runs.map {
                it.toRunUiModel()
            }
        }
    }
}



