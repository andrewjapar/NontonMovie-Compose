package dev.andrewjap.nontonmovie.presentation.ui.filmdetail

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

abstract class FilmDetailViewModel : ViewModel() {
    abstract val showDetails: StateFlow<FilmDetailState>
    abstract fun loadDetails(id: Int)
}