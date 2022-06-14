package com.teamb.runningtracker.presentation.Welcome

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.*
import com.teamb.runningtracker.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun IntroScreen(nextClick: () -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = { nextClick() }) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "")
            }
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Loader(
                    Modifier
                        .fillMaxWidth()
                        .weight(4f)
                )
                Text(
                    modifier = Modifier
                        .weight(1f),
                    text = "Let's track your Run ", style = MaterialTheme.typography.body1
                )
            }
        }
    )
}


@Composable
fun Loader(modifier: Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.runcycle))
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