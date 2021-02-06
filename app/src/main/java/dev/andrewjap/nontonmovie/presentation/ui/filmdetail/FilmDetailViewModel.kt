package dev.andrewjap.nontonmovie.presentation.ui.filmdetail

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

class FilmDetailViewModel @ViewModelInject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    private val _showDetails = MutableStateFlow(FilmDetailState(isLoading = true))
    val showDetails: StateFlow<FilmDetailState>
        get() = _showDetails

    fun loadDetails(id: Int) {
        loadMovieDetails(id)
    }

    fun loadMovieDetails(id: Int) {
        viewModelScope.launch {
            combine(
                movieRepository.getDetail(id),
                movieRepository.getSimilar(id),
                movieRepository.getRecommendation(id)
            ) { details, similar, recommendation ->
                FilmDetailState(
                    details = details,
                    similar = similar,
                    recommendation = recommendation,
                    isLoading = false
                )
            }.safeCollect {
                _showDetails.value = it
            }
        }
    }

}