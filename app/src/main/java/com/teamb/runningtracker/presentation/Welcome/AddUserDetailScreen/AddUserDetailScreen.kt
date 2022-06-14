package com.teamb.runningtracker.presentation.Welcome.AddUserDetailScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddUserDetailScreen(
    navHostController: NavHostController,
    viewModel: AddUserAuthViewModel = hiltViewModel()
) {

    val state = viewModel.state

    Scaffold(Modifier.fillMaxSize(), floatingActionButton = {
        FloatingActionButton(onClick = {
            viewModel.onEvent(AddUserDetailScreenEvent.OnSubmit)
        }) {
            Icon(imageVector = Icons.Default.Check, contentDescription = "")
        }
    }
    ) {

        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                Modifier.fillMaxSize().padding(48.dp),
                verticalArrangement = Arrangement.Center
            ) {

                OutlinedTextField(
                    value = state.firstName,
                    onValueChange = {
                        viewModel.onEvent(AddUserDetailScreenEvent.OnFirstNameChange(it))
                    },
                    isError = state.firstNameError != null,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    label = { Text(text = "First Name") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, start = 12.dp, end = 12.dp)
                )

                if (state.firstNameError != null && state.firstNameError.isNotBlank()) {
                    Text(
                        text = state.firstNameError,
                        color = MaterialTheme.colors.error,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }


                OutlinedTextField(
                    value = state.lastName,
                    onValueChange = {
                        viewModel.onEvent(AddUserDetailScreenEvent.OnLastNameChange(it))
                    },
                    isError = state.lastNameError != null,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    label = { Text(text = "Last Name") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, start = 12.dp, end = 12.dp)
                )
                if (state.lastNameError != null && state.lastNameError.isNotBlank()) {
                    Text(
                        text = state.lastNameError,
                        color = MaterialTheme.colors.error,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }

                OutlinedTextField(
                    value = state.age.toString(),
                    onValueChange = {
                        viewModel.onEvent(AddUserDetailScreenEvent.OnAgeChange(it))
                    },
                    isError = state.ageError != null,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = { Text(text = "Age ") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, start = 12.dp, end = 12.dp)
                )
                if (state.ageError != null && state.ageError.isNotBlank()) {
                    Text(
                        text = state.ageError,
                        color = MaterialTheme.colors.error,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }


                OutlinedTextField(
                    value = state.weight.toString(),
                    onValueChange = {
                        viewModel.onEvent(AddUserDetailScreenEvent.OnWeightChange(it))
                    },
                    isError = state.weightError != null,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = { Text(text = "weight") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, start = 12.dp, end = 12.dp)
                )

                if (state.weightError != null && state.weightError.isNotBlank()) {
                    Text(
                        text = state.weightError,
                        color = MaterialTheme.colors.error,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
    }
}