package dev.andrewjap.nontonmovie.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.font
import androidx.compose.ui.text.font.fontFamily
import androidx.compose.ui.unit.sp
import dev.andrewjap.nontonmovie.R

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

private val fontFamily = FontFamily.Default

val NontonMovieTypography = Typography(
    h6 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    ),
    body1 = TextStyle(
        fontFamily = fontFamily,
        letterSpacing = 0.15.sp
    )
)
