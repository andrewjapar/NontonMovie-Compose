package dev.andrewjap.nontonmovie.presentation.ui.main.tv

import dev.andrewjap.nontonmovie.domain.entity.Film

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

data class TvShowState(
    val popularTvShow: List<Film.TvShow> = emptyList(),
    val latestTvShow: List<Film.TvShow> = emptyList(),
    val liveTodayTvShow: List<Film.TvShow> = emptyList(),
    val topRatedTvShow: List<Film.TvShow> = emptyList(),
    val isLoading: Boolean = false
)