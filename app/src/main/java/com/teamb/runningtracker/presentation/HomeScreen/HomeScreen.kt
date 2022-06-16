package com.teamb.runningtracker.presentation.HomeScreen

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.teamb.runningtracker.presentation.components.TopBar


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = {
            BottomNavigationBar()
        }
    ) {

    }
}

