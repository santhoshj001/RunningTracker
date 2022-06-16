package com.teamb.runningtracker.presentation.HomeScreen

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable


@Composable
fun BottomNavigationBar() {
    val items = listOf(
        NavigationItem.RunInfo,
        NavigationItem.RunInsights,
        NavigationItem.Profile
    )
    BottomNavigation() {
        items.forEach {
            BottomNavigationItem(
                selected = it.route == "Run Info" ,
                label = {
                    Text(text = it.title)
                },
                onClick = { },
                alwaysShowLabel = true,
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = ""
                    )
                }
            )
        }
    }
}