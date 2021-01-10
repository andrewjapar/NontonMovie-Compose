package dev.andrewjap.nontonmovie.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.font
import androidx.compose.ui.text.font.fontFamily
import androidx.compose.ui.unit.sp
import dev.andrewjap.nontonmovie.R

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

private val fontFamily = fontFamily(
    font(R.font.roboto_light, FontWeight.Light),
    font(R.font.roboto_regular, FontWeight.Normal),
    font(R.font.roboto_medium, FontWeight.Medium),
    font(R.font.roboto_bold, FontWeight.SemiBold)
)

val NontonMovieTypography = Typography(
    h6 = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),
    body1 = TextStyle(
        fontFamily = fontFamily,
        letterSpacing = 0.15.sp
    )
)
