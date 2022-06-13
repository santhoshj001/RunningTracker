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

            is AuthScreenEvent.OnFirstNameChange -> {
                state = state.copy(
                    firstName = event.firstName
                )
            }
            is AuthScreenEvent.OnLastNameChange -> {
                state = state.copy(lastName = event.lastName)
            }
            is AuthScreenEvent.OnAgeChange -> {
                state = state.copy(age = event.age)
            }
            is AuthScreenEvent.OnWeightChange -> {
                state = state.copy(weight = event.weight)
            }
            is AuthScreenEvent.OnSubmit -> {
                saveUserDetail()
            }
        }
    }

    private fun getUserDetail() {
        viewModelScope.launch {
            userDetailUseCase.getUserDetailUseCase.invoke().collect {
                state = state.copy(
                    firstName = it.firstName,
                    lastName = it.lastName,
                    age = it.age.toString(),
                    weight = it.weight.toString()
                )
            }
        }
    }

    private fun saveUserDetail() {
        val firstNameResult = validationUseCase.firstNameValidationUseCase(state.firstName)
        val lastNameResult = validationUseCase.lastNameValidationUseCase(state.lastName)
        val ageResult = validationUseCase.ageValidationUseCase(state.age)
        val weightResult = validationUseCase.weightValidationUseCase(state.weight)

        val hasErrors =
            listOf(firstNameResult, lastNameResult, ageResult, weightResult).any { !it.isSuccess }
        if (hasErrors) {
            state = state.copy(
                firstNameError = firstNameResult.errorMessage,
                lastNameError = lastNameResult.errorMessage,
                ageError = ageResult.errorMessage,
                weightError = weightResult.errorMessage
            )
        } else {
            viewModelScope.launch {
                val userDetailUiModel = UserDetailUiModel(
                    firstName = state.firstName,
                    lastName = state.lastName,
                    age = state.age.toInt(),
                    weight = state.weight.toInt()
                )
                userDetailUseCase.saveUserDetailUseCase.saveUSerDetail(userDetailUiModel)
            }
        }
    }
}