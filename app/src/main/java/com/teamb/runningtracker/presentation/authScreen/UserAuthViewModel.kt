package com.teamb.runningtracker.presentation.authScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teamb.runningtracker.domain.model.UserDetailUiModel
import com.teamb.runningtracker.domain.usecase.userdetail.UserDetailUseCase
import com.teamb.runningtracker.domain.usecase.validation.ValidationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserAuthViewModel @Inject constructor(
    private val userDetailUseCase: UserDetailUseCase,
    private val validationUseCase: ValidationUseCase
) : ViewModel() {

    init {
        getUserDetail()
    }

    var state by mutableStateOf(AuthScreenState())
        private set

    fun onEvent(event: AuthScreenEvent) {
        when (event) {
            AuthScreenEvent.OnSubmit -> saveUserDetail()
        }
    }

    private fun getUserDetail() {
        viewModelScope.launch {
            userDetailUseCase.getUserDetailUseCase.invoke().collectLatest {
                state = state.copy(
                    firstName = it.firstName,
                    lastName = it.lastName,
                    age = it.age,
                    weight = it.weight
                )
            }
        }
    }

    private fun saveUserDetail() {
        viewModelScope.launch {
            val userDetailUiModel = UserDetailUiModel(
                firstName = state.firstName,
                lastName = state.lastName,
                age = state.age,
                weight = state.weight
            )
            userDetailUseCase.saveUserDetailUseCase.saveUSerDetail(userDetailUiModel)
        }
    }
}