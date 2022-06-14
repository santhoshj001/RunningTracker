package com.teamb.runningtracker.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.teamb.runningtracker.presentation.Welcome.AddUserDetailScreen.AddUserDetailScreen
import com.teamb.runningtracker.presentation.Welcome.IntroScreen
import com.teamb.runningtracker.presentation.Welcome.PerMissionScreen
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(navHostController: NavHostController) {

    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState()
    Column(Modifier.fillMaxSize()) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            count = 3,
            state = pagerState,
            verticalAlignment = Alignment.CenterVertically,
            userScrollEnabled = false
        ) { position ->
            when (position) {
                0 -> {
                    IntroScreen(nextClick = {
                        scope.launch { pagerState.animateScrollToPage(page = 1, initialVelocity = 0.1f) }
                    })
                }
                1 -> {
                    PerMissionScreen(nextClick = {
                        scope.launch { pagerState.animateScrollToPage(2) }
                    })
                }
                2 -> {
                    AddUserDetailScreen(navHostController = navHostController)
                }
            }

        }
        HorizontalPagerIndicator(
            pagerState = pagerState,
            Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally)
        )
    }
}