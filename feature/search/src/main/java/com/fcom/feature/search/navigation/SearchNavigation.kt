package com.fcom.feature.search.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.fcom.feature.search.ui.SearchRoute

const val SEARCH_ROUTE = "search_route"

fun NavController.navigateToSearch(navOptions: NavOptions? = null) = navigate(SEARCH_ROUTE, navOptions)

fun NavGraphBuilder.searchScreen(
    onBackClick: () -> Unit,
    onItemClick: (String) -> Unit
) {
    composable(route = SEARCH_ROUTE) {
        SearchRoute(
            onBackClick = onBackClick,
            onItemClick = onItemClick
        )
    }
}