package com.teamb.runningtracker.presentation.Welcome

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberPermissionState
import com.teamb.runningtracker.R

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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LoadingLocation(
                    Modifier
                        .fillMaxWidth()
                        .weight(3f)
                )
                FeatureThatRequiresCameraPermission(
                    Modifier.weight(1f)
                )
            }

        }
    )
}


@Composable
fun LoadingLocation(modifier: Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.location_globe))
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever,
    )
    LottieAnimation(
        modifier = modifier,
        composition = composition,
        progress = progress,
    )
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
private fun FeatureThatRequiresCameraPermission(modifier: Modifier) {

    Box(modifier = modifier) {

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
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    val textToShow =
                        if ((locationPermissionState.status as PermissionStatus.Denied).shouldShowRationale) {
                            // If the user has denied the permission but the rationale can be shown,
                            // then gently explain why the app requires this permission
                            "The Location is important for this app. Please grant the permission."
                        } else {
                            // If it's the first time the user lands on this feature, or the user
                            // doesn't want to be asked again for this permission, explain that the
                            // permission is required
                            "Location permission required. " +
                                    "Please grant the permission"
                        }
                    Text(textToShow, textAlign = TextAlign.Center)

                    OutlinedButton(
                        modifier = Modifier.padding(vertical = 16.dp),
                        onClick = { locationPermissionState.launchPermissionRequest() }) {
                        Text("Allow Permission")
                    }
                }
            }
        }
    }
}