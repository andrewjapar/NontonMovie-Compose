package dev.andrewjap.nontonmovie.presentation.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import dagger.hilt.android.AndroidEntryPoint
import dev.andrewjap.nontonmovie.presentation.ui.main.home.HomeViewModel
import dev.andrewjap.nontonmovie.presentation.ui.main.movielist.MovieListViewModel
import dev.andrewjap.nontonmovie.presentation.ui.main.tvshowlist.TvShowListViewModel
import dev.andrewjap.nontonmovie.presentation.ui.theme.NontonMovieTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val homeViewModel: HomeViewModel by viewModels()
    private val tvShowsViewModel: TvShowListViewModel by viewModels()
    private val moviesListModel: MovieListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NontonMovieTheme {
                MainScreen(
                    homeViewModel = homeViewModel,
                    tvShowViewModel = tvShowsViewModel,
                    movieListViewModel = moviesListModel
                )
            }
        }
    }
}