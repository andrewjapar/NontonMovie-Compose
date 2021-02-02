package dev.andrewjap.nontonmovie.presentation.ui.main.movielist

import dev.andrewjap.nontonmovie.domain.entity.Film

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

data class MovieListState(
    val popular: List<Film.Movie> = emptyList(),
    val nowPlaying: List<Film.Movie> = emptyList(),
    val upcoming: List<Film.Movie> = emptyList(),
    val latest: List<Film.Movie> = emptyList(),
    val isLoading: Boolean = false
)