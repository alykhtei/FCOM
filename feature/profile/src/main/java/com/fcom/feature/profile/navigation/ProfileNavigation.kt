package com.fcom.feature.profile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.fcom.feature.profile.ui.ProfileRoute
import kotlinx.serialization.Serializable

@Serializable
object ProfileRoute

fun NavController.navigateToProfile(navOptions: NavOptions) =
    navigate(route = ProfileRoute, navOptions)

fun NavGraphBuilder.profileScreen(onShowSnackBar: suspend (String, String?) -> Boolean) {
    composable<ProfileRoute> {
        ProfileRoute(onShowSnackBar)
    }
}