package com.teamb.runningtracker.presentation.authScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AuthScreen(
    viewModel: UserAuthViewModel = hiltViewModel()
) {

    val state = viewModel.state
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {


            OutlinedTextField(
                value = state.firstName,
                onValueChange = {
                    viewModel.onEvent(AuthScreenEvent.OnFirstNameChange(it))
                },
                isError = state.firstNameError != null,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = { Text(text = "First Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )

            if (state.firstNameError != null && state.firstNameError.isNotBlank()) {
                Text(
                    text = state.firstNameError,
                    color = MaterialTheme.colors.error,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
                )
            }


            OutlinedTextField(
                value = state.lastName,
                onValueChange = {
                    viewModel.onEvent(AuthScreenEvent.OnLastNameChange(it))
                },
                isError = state.lastNameError != null,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = { Text(text = "Last Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )
            if (state.lastNameError != null && state.lastNameError.isNotBlank()) {
                Text(
                    text = state.lastNameError,
                    color = MaterialTheme.colors.error,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
                )
            }

            OutlinedTextField(
                value = state.age.toString(),
                onValueChange = {
                    viewModel.onEvent(AuthScreenEvent.OnAgeChange(it))
                },
                isError = state.ageError != null,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text(text = "Age ") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )
            if (state.ageError != null && state.ageError.isNotBlank()) {
                Text(
                    text = state.ageError,
                    color = MaterialTheme.colors.error,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
                )
            }


            OutlinedTextField(
                value = state.weight.toString(),
                onValueChange = {
                    viewModel.onEvent(AuthScreenEvent.OnWeightChange(it))
                },
                isError = state.weightError != null,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text(text = "weight") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )

            if (state.weightError != null && state.weightError.isNotBlank()) {
                Text(
                    text = state.weightError,
                    color = MaterialTheme.colors.error,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
                )
            }


            OutlinedButton(
                onClick = { viewModel.onEvent(AuthScreenEvent.OnSubmit) },
                modifier = Modifier.padding(vertical = 12.dp)
            ) {
                Text(
                    text = "SUBMIT",
                    modifier = Modifier.padding(horizontal = 32.dp, vertical = 4.dp)
                )
            }
        }
    }
}