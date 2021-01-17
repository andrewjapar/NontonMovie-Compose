package dev.andrewjap.nontonmovie.domain.entity

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

data class Movie(
    val id: Int,
    val title: String,
    val description: String = "",
    val portraitImage: String = "",
    val landscapeImage: String = ""
)