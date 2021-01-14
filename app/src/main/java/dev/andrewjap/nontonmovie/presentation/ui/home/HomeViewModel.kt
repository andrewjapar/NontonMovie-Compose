package dev.andrewjap.nontonmovie.presentation.ui.home

import android.os.Bundle
import androidx.annotation.MainThread
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.os.bundleOf
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
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
    private val movieRepository: MovieRepository,
    @Assisted savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _showMovies = MutableStateFlow(HomeViewState())
    val showMovies: StateFlow<HomeViewState>
        get() = _showMovies

    var currentScreen: Screen by savedStateHandle.getMutableStateOf<Screen>(
        key = "SIS_SCREEN",
        default = Screen.Home,
        save = { it.toBundle() },
        restore = { it.toScreen() }
    )

    init {
        loadMovies()
    }

    @MainThread
    fun navigateTo(screen: Screen) {
        currentScreen = screen
    }

    @MainThread
    fun onBack(): Boolean {
        val wasHandled = currentScreen != Screen.Home
        currentScreen = Screen.Home
        return wasHandled
    }

    private fun loadMovies() {
        viewModelScope.launch {
            movieRepository.get().safeCollect {
                _showMovies.value = HomeViewState(popularMovies = it)
            }
        }
    }

    private fun <T> SavedStateHandle.getMutableStateOf(
        key: String,
        default: T,
        save: (T) -> Bundle,
        restore: (Bundle) -> T
    ): MutableState<T> {
        val bundle: Bundle? = get(key)
        val initial = if (bundle == null) {
            default
        } else {
            restore(bundle)
        }
        val state = mutableStateOf(initial)
        setSavedStateProvider(key) {
            save(state.value)
        }
        return state
    }

    private fun Screen.toBundle(): Bundle {
        return bundleOf(SIS_NAME to id.name)
    }

    private fun Bundle.toScreen(): Screen {
        return when (ScreenName.valueOf(getStringOrThrow(SIS_NAME))) {
            ScreenName.HOME -> Screen.Home
            ScreenName.SETTINGS -> Screen.Settings
        }
    }

    private fun Bundle.getStringOrThrow(key: String) =
        requireNotNull(getString(key)) { "Missing key '$key' in $this" }

    companion object {
        private const val SIS_SCREEN = "sis_screen"
        private const val SIS_NAME = "screen_name"
        private const val SIS_POST = "post"
    }
}

data class HomeViewState(
    val popularMovies: List<Movie> = emptyList(),
    val asd: Boolean = false
)

enum class ScreenName { HOME, SETTINGS }
sealed class Screen(val id: ScreenName) {
    object Home : Screen(ScreenName.HOME)
    object Settings : Screen(ScreenName.SETTINGS)
}