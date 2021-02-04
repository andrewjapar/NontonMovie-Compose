package dev.andrewjap.nontonmovie.presentation.ui.main.genrelist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.andrewjap.nontonmovie.data.repository.GenreRepository
import dev.andrewjap.nontonmovie.extension.safeCollect
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

class GenreListViewModel @ViewModelInject constructor(
    private val genreRepository: GenreRepository
) : ViewModel() {

    private val _showGenres = MutableStateFlow(GenreListState(isLoading = true))
    val showGenres: StateFlow<GenreListState>
        get() = _showGenres

    init {
        fetchGenres()
    }

    private fun fetchGenres() {
        viewModelScope.launch {
            genreRepository.getMovieGenre().safeCollect(
                onSuccess = {
                    _showGenres.value = GenreListState(movieGenres = it, isLoading = false)
                }
            )
        }
    }
}