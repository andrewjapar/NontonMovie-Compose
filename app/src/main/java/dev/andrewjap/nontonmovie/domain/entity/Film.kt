package dev.andrewjap.nontonmovie.domain.entity

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

sealed class Film {
    abstract val id: Int
    abstract val title: String
    abstract val description: String
    abstract val portraitImage: String
    abstract val landscapeImage: String

    data class Movie(
        override val id: Int,
        override val title: String,
        override val description: String = "",
        override val portraitImage: String = "",
        override val landscapeImage: String = ""
    ) : Film()

    data class TvShow(
        override val id: Int,
        override val title: String,
        override val description: String = "",
        override val portraitImage: String = "",
        override val landscapeImage: String = ""
    ) : Film()
}