package com.fcom.core.designsystem.component.anotations

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

/**
 * Multi preview annotation that represents light and dark themes. Add this annotation to a
 * composable to render the both themes.
 */

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, name = "Light Theme")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Theme")
annotation class ThemePreviews