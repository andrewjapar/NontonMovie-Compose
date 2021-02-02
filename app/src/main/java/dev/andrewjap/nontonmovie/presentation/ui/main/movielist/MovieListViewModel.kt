package dev.andrewjap.nontonmovie.presentation.ui.main.movielist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.andrewjap.nontonmovie.data.repository.MovieRepository
import dev.andrewjap.nontonmovie.extension.safeCollect
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

class MovieListViewModel @ViewModelInject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _showMovies = MutableStateFlow(MovieListState(isLoading = true))
    val showMovies: StateFlow<MovieListState>
        get() = _showMovies

    init {
        loadTvShows()
    }

    private fun loadTvShows() {
        viewModelScope.launch {
            combine(
                movieRepository.getPopular(),
                movieRepository.getNowPlaying(),
                movieRepository.getUpcoming(),
                movieRepository.getLatest()
            ) { popular, nowPlaying, upcoming, latest ->
                MovieListState(
                    popular = popular,
                    upcoming = upcoming,
                    nowPlaying = nowPlaying,
                    latest = latest,
                    isLoading = false
                )
            }.safeCollect {
                _showMovies.value = it
            }
        }
    }
}