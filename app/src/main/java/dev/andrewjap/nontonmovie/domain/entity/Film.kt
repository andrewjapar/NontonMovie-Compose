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
    abstract val genres: List<String>

    data class Movie(
        override val id: Int,
        override val title: String,
        override val description: String = "",
        override val portraitImage: String = "",
        override val landscapeImage: String = "",
        override val genres: List<String> = emptyList()
    ) : Film()

    data class TvShow(
        override val id: Int,
        override val title: String,
        override val description: String = "",
        override val portraitImage: String = "",
        override val landscapeImage: String = "",
        override val genres: List<String> = emptyList()
    ) : Film()
}