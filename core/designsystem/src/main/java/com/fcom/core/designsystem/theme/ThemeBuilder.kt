package com.fcom.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@Immutable
data class GradientColors(
    val top: Color = Color.Unspecified,
    val bottom: Color = Color.Unspecified,
    val container: Color = Color.Unspecified
)

@Immutable
data class BackgroundTheme(
    val color: Color = Color.Unspecified,
    val tonalElevation: Dp = Dp.Unspecified,
)

@Immutable
data class TintTheme(
    val iconTint: Color = Color.Unspecified
)

/**
 * A composition local for [BackgroundTheme], [GradientColors] and [TintTheme].
 */
val LocalBackgroundTheme = staticCompositionLocalOf { BackgroundTheme() }
val LocalGradientColors = staticCompositionLocalOf { GradientColors() }
val LocalTintTheme = staticCompositionLocalOf { TintTheme() }
