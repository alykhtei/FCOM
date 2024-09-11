package com.example.firstcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.example.firstcompose.ui.FComAppState
import com.fcom.feature.home.navigation.HomeRoute
import com.fcom.feature.home.navigation.homeScreen
import com.fcom.feature.profile.navigation.profileScreen

@Composable
fun FComNavHost(
    appState: FComAppState,
    onShowSnackBar: suspend (String, String?) -> Boolean,
    modifier: Modifier = Modifier
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = HomeRoute,
        modifier = modifier
    ) {
        homeScreen()
        profileScreen(onShowSnackBar = onShowSnackBar)
    }
}