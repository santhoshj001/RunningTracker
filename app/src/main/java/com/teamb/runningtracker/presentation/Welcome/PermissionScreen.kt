package com.teamb.runningtracker.presentation.Welcome

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberPermissionState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun PerMissionScreen(nextClick: () -> Unit) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        floatingActionButton = {
            FloatingActionButton(onClick = { nextClick() }) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "")
            }
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                FeatureThatRequiresCameraPermission()
            }

        }
    )
}


@OptIn(ExperimentalPermissionsApi::class)
@Composable
private fun FeatureThatRequiresCameraPermission() {

    // Location permission state
    val locationPermissionState = rememberPermissionState(
        android.Manifest.permission.ACCESS_FINE_LOCATION,
    )

    when (locationPermissionState.status) {
        // If the Location permission is granted, then show screen with the feature enabled
        PermissionStatus.Granted -> {
            Text("Location permission Granted")
        }
        is PermissionStatus.Denied -> {
            Column {
                val textToShow =
                    if ((locationPermissionState.status as PermissionStatus.Denied).shouldShowRationale) {
                        // If the user has denied the permission but the rationale can be shown,
                        // then gently explain why the app requires this permission
                        "The Location is important for this app. Please grant the permission."
                    } else {
                        // If it's the first time the user lands on this feature, or the user
                        // doesn't want to be asked again for this permission, explain that the
                        // permission is required
                        "Location permission required for this feature to be available. " +
                                "Please grant the permission"
                    }
                Text(textToShow)

                Button(onClick = { locationPermissionState.launchPermissionRequest() }) {
                    Text("Request permission")
                }
            }
        }
    }
}