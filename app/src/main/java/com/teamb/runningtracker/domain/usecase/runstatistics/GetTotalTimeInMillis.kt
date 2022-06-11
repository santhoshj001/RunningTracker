package com.teamb.runningtracker.domain.usecase.runstatistics

import com.teamb.runningtracker.data.repository.RunLocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTotalTimeInMillis @Inject constructor(
    private val repository: RunLocalRepository
) {
    operator fun invoke(): Flow<Long> {
        return repository.getTotalTimeInMillis()
    }
}



