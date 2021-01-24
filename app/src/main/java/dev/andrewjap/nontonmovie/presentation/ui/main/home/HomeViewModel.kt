package dev.andrewjap.nontonmovie.presentation.ui.main.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.andrewjap.nontonmovie.data.repository.MovieRepository
import dev.andrewjap.nontonmovie.domain.entity.Movie
import dev.andrewjap.nontonmovie.extension.safeCollect
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

class HomeViewModel @ViewModelInject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _showMovies = MutableStateFlow(HomeViewState(isLoading = true))
    val showMovies: StateFlow<HomeViewState>
        get() = _showMovies

    init {
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch {
            movieRepository.get().safeCollect {
                _showMovies.value = HomeViewState(popularMovies = it)
            }
        }
    }
}

data class HomeViewState(
    val popularMovies: List<Movie> = emptyList(),
    val isLoading: Boolean = false
)