package com.alg.metawallpaper.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import com.alg.metawallpaper.R

private val lightColorScheme = lightColorScheme(
    primary = pink100,
    secondary = pink900,
    background = white,
    surface = white850,
    onPrimary = gray,
    onSecondary = white,
    onBackground = gray,
    onSurface = gray,
)

private val darkColorScheme = darkColorScheme(
    primary = green900,
    secondary = green300,
    background = gray,
    surface = white150,
    onPrimary = white,
    onSecondary = gray,
    onBackground = white,
    onSurface = white850
)

open class WelcomeAssets private constructor(
    var background: Int,
    var illos: Int,
    var logo: Int
) {
    object LightWelcomeAssets : WelcomeAssets(
        background = R.drawable.ic_light_welcome_bg,
        illos = R.drawable.ic_light_welcome_illos,
        logo = R.drawable.ic_light_logo
    )

    object DarkWelcomeAssets : WelcomeAssets(
        background = R.drawable.ic_dark_welcome_bg,
        illos = R.drawable.ic_dark_welcome_illos,
        logo = R.drawable.ic_dark_logo
    )
}

internal var LocalWelcomeAssets = staticCompositionLocalOf { WelcomeAssets.LightWelcomeAssets as WelcomeAssets }

val MaterialTheme.welcomeAssets
    @Composable
    @ReadOnlyComposable
    get() = LocalWelcomeAssets.current

enum class BloomTheme {
    LIGHT, DARK
}

@Composable
fun MetaWallpaperTheme(theme: BloomTheme = BloomTheme.LIGHT, content: @Composable() () -> Unit) {
    CompositionLocalProvider(
        LocalWelcomeAssets provides if (theme == BloomTheme.DARK) WelcomeAssets.DarkWelcomeAssets else WelcomeAssets.LightWelcomeAssets,
    ) {
        MaterialTheme(
            colorScheme = if (theme == BloomTheme.DARK) darkColorScheme else lightColorScheme,
            typography = bloomTypography,
            shapes = shapes,
            content = content
        )
    }
}