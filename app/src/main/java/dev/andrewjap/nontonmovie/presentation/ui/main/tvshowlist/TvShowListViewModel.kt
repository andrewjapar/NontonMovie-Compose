package dev.andrewjap.nontonmovie.presentation.ui.main.tvshowlist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.andrewjap.nontonmovie.data.repository.TvShowRepository
import dev.andrewjap.nontonmovie.extension.safeCollect
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

class TvShowListViewModel @ViewModelInject constructor(
    private val tvShowRepository: TvShowRepository
) : ViewModel() {

    private val _showTvShows = MutableStateFlow(TvShowListState(isLoading = true))
    val showTvShows: StateFlow<TvShowListState>
        get() = _showTvShows

    init {
        loadTvShows()
    }

    private fun loadTvShows() {
        viewModelScope.launch {
            combine(
                tvShowRepository.getPopular(),
                tvShowRepository.getTopRated(),
                tvShowRepository.getLiveToday(),
                tvShowRepository.getLatest()
            ) { popular, topRated, liveToday, latest ->
                TvShowListState(
                    popularTvShow = popular,
                    topRatedTvShow = topRated,
                    liveTodayTvShow = liveToday,
                    latestTvShow = latest,
                    isLoading = false
                )
            }.safeCollect {
                _showTvShows.value = it
            }
        }
    }
}