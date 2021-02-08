package dev.andrewjap.nontonmovie.presentation.ui.filmdetail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import dev.andrewjap.nontonmovie.data.repository.TvShowRepository
import dev.andrewjap.nontonmovie.extension.safeCollect
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

class TvShowViewModel @ViewModelInject constructor(
    private val tvShowRepository: TvShowRepository
) : FilmDetailViewModel() {

    override val showDetails = MutableStateFlow(FilmDetailState(isLoading = true))

    override fun loadDetails(id: Int) {
        viewModelScope.launch {
            combine(
                tvShowRepository.getDetails(id),
                tvShowRepository.getSimilar(id),
                tvShowRepository.getRecommendation(id)
            ) { details, similar, recommendation ->
                FilmDetailState(
                    details = details,
                    similar = similar,
                    recommendation = recommendation,
                    isLoading = false
                )
            }.safeCollect {
                showDetails.value = it
            }
        }
    }

}