package dev.andrewjap.nontonmovie.presentation.ui.filmdetail

import dev.andrewjap.nontonmovie.domain.entity.Film

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

data class FilmDetailState(
    val details: Film? = null,
    val similar: List<Film> = emptyList(),
    val recommendation: List<Film> = emptyList(),
    val isLoading: Boolean = false
)