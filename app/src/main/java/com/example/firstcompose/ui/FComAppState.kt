package com.example.firstcompose.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.firstcompose.navigation.TopLevelDestination
import com.fcom.core.data.managers.impl.NetworkConnectionMonitor
import com.fcom.feature.home.navigation.navigateToHome
import com.fcom.feature.profile.navigation.navigateToProfile
import com.fcom.feature.search.navigation.navigateToSearch
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@Composable
fun rememberFComAppState(
    networkMonitor: NetworkConnectionMonitor,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController()
): FComAppState {
    return remember(
        navController,
        coroutineScope,
        networkMonitor
    ) {
        FComAppState(
            navController = navController,
            coroutineScope = coroutineScope,
            networkMonitor = networkMonitor
        )
    }
}

@Stable
class FComAppState(
    val navController: NavHostController,
    coroutineScope: CoroutineScope,
    networkMonitor: NetworkConnectionMonitor
) {

    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = TopLevelDestination.entries.firstOrNull { topLevelDestination ->
            currentDestination?.hasRoute(
                route = topLevelDestination.route
            ) ?: false
        }

    val isOffline = networkMonitor.isOnline
        .map(Boolean::not)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = false
        )

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {

        val topLevelNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }

        when (topLevelDestination) {
            TopLevelDestination.HOME -> {
                navController.navigateToHome(topLevelNavOptions)
            }

            TopLevelDestination.PROFILE -> {
                navController.navigateToProfile(topLevelNavOptions)
            }
        }
    }

    fun navigateToSearch() = navController.navigateToSearch()
}