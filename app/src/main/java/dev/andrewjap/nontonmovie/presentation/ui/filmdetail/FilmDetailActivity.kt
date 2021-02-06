package dev.andrewjap.nontonmovie.presentation.ui.filmdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import dagger.hilt.android.AndroidEntryPoint
import dev.andrewjap.nontonmovie.presentation.ui.theme.NontonMovieTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class FilmDetailActivity : AppCompatActivity() {

    private val viewModel: FilmDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NontonMovieTheme {
                FilmDetailScreen()
            }
        }

        viewModel.loadDetails(getId())
    }

    private fun getId(): Int {
        return intent.getIntExtra(MOVIE_ID, 0)
    }

    companion object {
        private const val MOVIE_ID = "movie_id"

        fun navigate(context: Context, id: Int) {
            Intent(context, FilmDetailActivity::class.java).apply {
                putExtra(MOVIE_ID, id)
            }.let { context.startActivity(it) }
        }
    }

}