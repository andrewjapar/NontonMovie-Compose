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
class TvShowDetailActivity : AppCompatActivity() {

    private val viewModel: TvShowViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NontonMovieTheme {
                FilmDetailScreen(viewModel)
            }
        }

        viewModel.loadDetails(getId())
    }

    private fun getId(): Int {
        return intent.getIntExtra(TV_SHOW_ID, 0)
    }

    companion object {
        private const val TV_SHOW_ID = "tvshow_id"

        fun navigate(context: Context, id: Int) {
            Intent(context, TvShowDetailActivity::class.java).apply {
                putExtra(TV_SHOW_ID, id)
            }.let { context.startActivity(it) }
        }
    }

}