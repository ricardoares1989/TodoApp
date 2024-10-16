package com.example.compose
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.juandgaines.todoapp.ui.theme.AppTypography
import com.juandgaines.todoapp.ui.theme.backgroundDark
import com.juandgaines.todoapp.ui.theme.backgroundDarkHighContrast
import com.juandgaines.todoapp.ui.theme.backgroundDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.backgroundLight
import com.juandgaines.todoapp.ui.theme.backgroundLightHighContrast
import com.juandgaines.todoapp.ui.theme.backgroundLightMediumContrast
import com.juandgaines.todoapp.ui.theme.errorContainerDark
import com.juandgaines.todoapp.ui.theme.errorContainerDarkHighContrast
import com.juandgaines.todoapp.ui.theme.errorContainerDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.errorContainerLight
import com.juandgaines.todoapp.ui.theme.errorContainerLightHighContrast
import com.juandgaines.todoapp.ui.theme.errorContainerLightMediumContrast
import com.juandgaines.todoapp.ui.theme.errorDark
import com.juandgaines.todoapp.ui.theme.errorDarkHighContrast
import com.juandgaines.todoapp.ui.theme.errorDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.errorLight
import com.juandgaines.todoapp.ui.theme.errorLightHighContrast
import com.juandgaines.todoapp.ui.theme.errorLightMediumContrast
import com.juandgaines.todoapp.ui.theme.inverseOnSurfaceDark
import com.juandgaines.todoapp.ui.theme.inverseOnSurfaceDarkHighContrast
import com.juandgaines.todoapp.ui.theme.inverseOnSurfaceDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.inverseOnSurfaceLight
import com.juandgaines.todoapp.ui.theme.inverseOnSurfaceLightHighContrast
import com.juandgaines.todoapp.ui.theme.inverseOnSurfaceLightMediumContrast
import com.juandgaines.todoapp.ui.theme.inversePrimaryDark
import com.juandgaines.todoapp.ui.theme.inversePrimaryDarkHighContrast
import com.juandgaines.todoapp.ui.theme.inversePrimaryDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.inversePrimaryLight
import com.juandgaines.todoapp.ui.theme.inversePrimaryLightHighContrast
import com.juandgaines.todoapp.ui.theme.inversePrimaryLightMediumContrast
import com.juandgaines.todoapp.ui.theme.inverseSurfaceDark
import com.juandgaines.todoapp.ui.theme.inverseSurfaceDarkHighContrast
import com.juandgaines.todoapp.ui.theme.inverseSurfaceDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.inverseSurfaceLight
import com.juandgaines.todoapp.ui.theme.inverseSurfaceLightHighContrast
import com.juandgaines.todoapp.ui.theme.inverseSurfaceLightMediumContrast
import com.juandgaines.todoapp.ui.theme.onBackgroundDark
import com.juandgaines.todoapp.ui.theme.onBackgroundDarkHighContrast
import com.juandgaines.todoapp.ui.theme.onBackgroundDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.onBackgroundLight
import com.juandgaines.todoapp.ui.theme.onBackgroundLightHighContrast
import com.juandgaines.todoapp.ui.theme.onBackgroundLightMediumContrast
import com.juandgaines.todoapp.ui.theme.onErrorContainerDark
import com.juandgaines.todoapp.ui.theme.onErrorContainerDarkHighContrast
import com.juandgaines.todoapp.ui.theme.onErrorContainerDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.onErrorContainerLight
import com.juandgaines.todoapp.ui.theme.onErrorContainerLightHighContrast
import com.juandgaines.todoapp.ui.theme.onErrorContainerLightMediumContrast
import com.juandgaines.todoapp.ui.theme.onErrorDark
import com.juandgaines.todoapp.ui.theme.onErrorDarkHighContrast
import com.juandgaines.todoapp.ui.theme.onErrorDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.onErrorLight
import com.juandgaines.todoapp.ui.theme.onErrorLightHighContrast
import com.juandgaines.todoapp.ui.theme.onErrorLightMediumContrast
import com.juandgaines.todoapp.ui.theme.onPrimaryContainerDark
import com.juandgaines.todoapp.ui.theme.onPrimaryContainerDarkHighContrast
import com.juandgaines.todoapp.ui.theme.onPrimaryContainerDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.onPrimaryContainerLight
import com.juandgaines.todoapp.ui.theme.onPrimaryContainerLightHighContrast
import com.juandgaines.todoapp.ui.theme.onPrimaryContainerLightMediumContrast
import com.juandgaines.todoapp.ui.theme.onPrimaryDark
import com.juandgaines.todoapp.ui.theme.onPrimaryDarkHighContrast
import com.juandgaines.todoapp.ui.theme.onPrimaryDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.onPrimaryLight
import com.juandgaines.todoapp.ui.theme.onPrimaryLightHighContrast
import com.juandgaines.todoapp.ui.theme.onPrimaryLightMediumContrast
import com.juandgaines.todoapp.ui.theme.onSecondaryContainerDark
import com.juandgaines.todoapp.ui.theme.onSecondaryContainerDarkHighContrast
import com.juandgaines.todoapp.ui.theme.onSecondaryContainerDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.onSecondaryContainerLight
import com.juandgaines.todoapp.ui.theme.onSecondaryContainerLightHighContrast
import com.juandgaines.todoapp.ui.theme.onSecondaryContainerLightMediumContrast
import com.juandgaines.todoapp.ui.theme.onSecondaryDark
import com.juandgaines.todoapp.ui.theme.onSecondaryDarkHighContrast
import com.juandgaines.todoapp.ui.theme.onSecondaryDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.onSecondaryLight
import com.juandgaines.todoapp.ui.theme.onSecondaryLightHighContrast
import com.juandgaines.todoapp.ui.theme.onSecondaryLightMediumContrast
import com.juandgaines.todoapp.ui.theme.onSurfaceDark
import com.juandgaines.todoapp.ui.theme.onSurfaceDarkHighContrast
import com.juandgaines.todoapp.ui.theme.onSurfaceDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.onSurfaceLight
import com.juandgaines.todoapp.ui.theme.onSurfaceLightHighContrast
import com.juandgaines.todoapp.ui.theme.onSurfaceLightMediumContrast
import com.juandgaines.todoapp.ui.theme.onSurfaceVariantDark
import com.juandgaines.todoapp.ui.theme.onSurfaceVariantDarkHighContrast
import com.juandgaines.todoapp.ui.theme.onSurfaceVariantDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.onSurfaceVariantLight
import com.juandgaines.todoapp.ui.theme.onSurfaceVariantLightHighContrast
import com.juandgaines.todoapp.ui.theme.onSurfaceVariantLightMediumContrast
import com.juandgaines.todoapp.ui.theme.onTertiaryContainerDark
import com.juandgaines.todoapp.ui.theme.onTertiaryContainerDarkHighContrast
import com.juandgaines.todoapp.ui.theme.onTertiaryContainerDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.onTertiaryContainerLight
import com.juandgaines.todoapp.ui.theme.onTertiaryContainerLightHighContrast
import com.juandgaines.todoapp.ui.theme.onTertiaryContainerLightMediumContrast
import com.juandgaines.todoapp.ui.theme.onTertiaryDark
import com.juandgaines.todoapp.ui.theme.onTertiaryDarkHighContrast
import com.juandgaines.todoapp.ui.theme.onTertiaryDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.onTertiaryLight
import com.juandgaines.todoapp.ui.theme.onTertiaryLightHighContrast
import com.juandgaines.todoapp.ui.theme.onTertiaryLightMediumContrast
import com.juandgaines.todoapp.ui.theme.outlineDark
import com.juandgaines.todoapp.ui.theme.outlineDarkHighContrast
import com.juandgaines.todoapp.ui.theme.outlineDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.outlineLight
import com.juandgaines.todoapp.ui.theme.outlineLightHighContrast
import com.juandgaines.todoapp.ui.theme.outlineLightMediumContrast
import com.juandgaines.todoapp.ui.theme.outlineVariantDark
import com.juandgaines.todoapp.ui.theme.outlineVariantDarkHighContrast
import com.juandgaines.todoapp.ui.theme.outlineVariantDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.outlineVariantLight
import com.juandgaines.todoapp.ui.theme.outlineVariantLightHighContrast
import com.juandgaines.todoapp.ui.theme.outlineVariantLightMediumContrast
import com.juandgaines.todoapp.ui.theme.primaryContainerDark
import com.juandgaines.todoapp.ui.theme.primaryContainerDarkHighContrast
import com.juandgaines.todoapp.ui.theme.primaryContainerDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.primaryContainerLight
import com.juandgaines.todoapp.ui.theme.primaryContainerLightHighContrast
import com.juandgaines.todoapp.ui.theme.primaryContainerLightMediumContrast
import com.juandgaines.todoapp.ui.theme.primaryDark
import com.juandgaines.todoapp.ui.theme.primaryDarkHighContrast
import com.juandgaines.todoapp.ui.theme.primaryDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.primaryLight
import com.juandgaines.todoapp.ui.theme.primaryLightHighContrast
import com.juandgaines.todoapp.ui.theme.primaryLightMediumContrast
import com.juandgaines.todoapp.ui.theme.scrimDark
import com.juandgaines.todoapp.ui.theme.scrimDarkHighContrast
import com.juandgaines.todoapp.ui.theme.scrimDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.scrimLight
import com.juandgaines.todoapp.ui.theme.scrimLightHighContrast
import com.juandgaines.todoapp.ui.theme.scrimLightMediumContrast
import com.juandgaines.todoapp.ui.theme.secondaryContainerDark
import com.juandgaines.todoapp.ui.theme.secondaryContainerDarkHighContrast
import com.juandgaines.todoapp.ui.theme.secondaryContainerDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.secondaryContainerLight
import com.juandgaines.todoapp.ui.theme.secondaryContainerLightHighContrast
import com.juandgaines.todoapp.ui.theme.secondaryContainerLightMediumContrast
import com.juandgaines.todoapp.ui.theme.secondaryDark
import com.juandgaines.todoapp.ui.theme.secondaryDarkHighContrast
import com.juandgaines.todoapp.ui.theme.secondaryDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.secondaryLight
import com.juandgaines.todoapp.ui.theme.secondaryLightHighContrast
import com.juandgaines.todoapp.ui.theme.secondaryLightMediumContrast
import com.juandgaines.todoapp.ui.theme.surfaceBrightDark
import com.juandgaines.todoapp.ui.theme.surfaceBrightDarkHighContrast
import com.juandgaines.todoapp.ui.theme.surfaceBrightDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.surfaceBrightLight
import com.juandgaines.todoapp.ui.theme.surfaceBrightLightHighContrast
import com.juandgaines.todoapp.ui.theme.surfaceBrightLightMediumContrast
import com.juandgaines.todoapp.ui.theme.surfaceContainerDark
import com.juandgaines.todoapp.ui.theme.surfaceContainerDarkHighContrast
import com.juandgaines.todoapp.ui.theme.surfaceContainerDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.surfaceContainerHighDark
import com.juandgaines.todoapp.ui.theme.surfaceContainerHighDarkHighContrast
import com.juandgaines.todoapp.ui.theme.surfaceContainerHighDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.surfaceContainerHighLight
import com.juandgaines.todoapp.ui.theme.surfaceContainerHighLightHighContrast
import com.juandgaines.todoapp.ui.theme.surfaceContainerHighLightMediumContrast
import com.juandgaines.todoapp.ui.theme.surfaceContainerHighestDark
import com.juandgaines.todoapp.ui.theme.surfaceContainerHighestDarkHighContrast
import com.juandgaines.todoapp.ui.theme.surfaceContainerHighestDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.surfaceContainerHighestLight
import com.juandgaines.todoapp.ui.theme.surfaceContainerHighestLightHighContrast
import com.juandgaines.todoapp.ui.theme.surfaceContainerHighestLightMediumContrast
import com.juandgaines.todoapp.ui.theme.surfaceContainerLight
import com.juandgaines.todoapp.ui.theme.surfaceContainerLightHighContrast
import com.juandgaines.todoapp.ui.theme.surfaceContainerLightMediumContrast
import com.juandgaines.todoapp.ui.theme.surfaceContainerLowDark
import com.juandgaines.todoapp.ui.theme.surfaceContainerLowDarkHighContrast
import com.juandgaines.todoapp.ui.theme.surfaceContainerLowDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.surfaceContainerLowLight
import com.juandgaines.todoapp.ui.theme.surfaceContainerLowLightHighContrast
import com.juandgaines.todoapp.ui.theme.surfaceContainerLowLightMediumContrast
import com.juandgaines.todoapp.ui.theme.surfaceContainerLowestDark
import com.juandgaines.todoapp.ui.theme.surfaceContainerLowestDarkHighContrast
import com.juandgaines.todoapp.ui.theme.surfaceContainerLowestDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.surfaceContainerLowestLight
import com.juandgaines.todoapp.ui.theme.surfaceContainerLowestLightHighContrast
import com.juandgaines.todoapp.ui.theme.surfaceContainerLowestLightMediumContrast
import com.juandgaines.todoapp.ui.theme.surfaceDark
import com.juandgaines.todoapp.ui.theme.surfaceDarkHighContrast
import com.juandgaines.todoapp.ui.theme.surfaceDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.surfaceDimDark
import com.juandgaines.todoapp.ui.theme.surfaceDimDarkHighContrast
import com.juandgaines.todoapp.ui.theme.surfaceDimDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.surfaceDimLight
import com.juandgaines.todoapp.ui.theme.surfaceDimLightHighContrast
import com.juandgaines.todoapp.ui.theme.surfaceDimLightMediumContrast
import com.juandgaines.todoapp.ui.theme.surfaceLight
import com.juandgaines.todoapp.ui.theme.surfaceLightHighContrast
import com.juandgaines.todoapp.ui.theme.surfaceLightMediumContrast
import com.juandgaines.todoapp.ui.theme.surfaceVariantDark
import com.juandgaines.todoapp.ui.theme.surfaceVariantDarkHighContrast
import com.juandgaines.todoapp.ui.theme.surfaceVariantDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.surfaceVariantLight
import com.juandgaines.todoapp.ui.theme.surfaceVariantLightHighContrast
import com.juandgaines.todoapp.ui.theme.surfaceVariantLightMediumContrast
import com.juandgaines.todoapp.ui.theme.tertiaryContainerDark
import com.juandgaines.todoapp.ui.theme.tertiaryContainerDarkHighContrast
import com.juandgaines.todoapp.ui.theme.tertiaryContainerDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.tertiaryContainerLight
import com.juandgaines.todoapp.ui.theme.tertiaryContainerLightHighContrast
import com.juandgaines.todoapp.ui.theme.tertiaryContainerLightMediumContrast
import com.juandgaines.todoapp.ui.theme.tertiaryDark
import com.juandgaines.todoapp.ui.theme.tertiaryDarkHighContrast
import com.juandgaines.todoapp.ui.theme.tertiaryDarkMediumContrast
import com.juandgaines.todoapp.ui.theme.tertiaryLight
import com.juandgaines.todoapp.ui.theme.tertiaryLightHighContrast
import com.juandgaines.todoapp.ui.theme.tertiaryLightMediumContrast

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun TodoAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
          val context = LocalContext.current
          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      
      darkTheme -> darkScheme
      else -> lightScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = AppTypography,
    content = content
  )
}

