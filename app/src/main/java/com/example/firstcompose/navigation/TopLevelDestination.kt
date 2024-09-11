package com.example.firstcompose.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.firstcompose.R
import com.fcom.core.designsystem.icon.FComIcons
import com.fcom.feature.home.navigation.HomeRoute
import com.fcom.feature.profile.navigation.ProfileRoute
import kotlin.reflect.KClass
import com.fcom.feature.home.R as homeRes
import com.fcom.feature.profile.R as profileRes

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    @StringRes val iconTextId: Int,
    @StringRes val titleTextId: Int,
    val route: KClass<*>
) {

    HOME(
        selectedIcon = FComIcons.Home,
        unselectedIcon = FComIcons.HomeBorder,
        iconTextId = homeRes.string.feature_home_title,
        titleTextId = R.string.app_name,
        route = HomeRoute::class
    ),
    PROFILE(
        selectedIcon = FComIcons.Profile,
        unselectedIcon = FComIcons.ProfileBorder,
        iconTextId = profileRes.string.feature_profile_title,
        titleTextId = R.string.app_name,
        route = ProfileRoute::class
    )
}