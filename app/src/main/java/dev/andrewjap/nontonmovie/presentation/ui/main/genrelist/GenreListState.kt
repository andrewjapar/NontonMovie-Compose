package dev.andrewjap.nontonmovie.presentation.ui.main.genrelist

import dev.andrewjap.nontonmovie.domain.entity.Genre

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

data class GenreListState(
    val movieGenres: List<Genre> = emptyList(),
    val isLoading: Boolean = false
)