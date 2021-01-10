package dev.andrewjap.nontonmovie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import dagger.hilt.android.AndroidEntryPoint
import dev.andrewjap.nontonmovie.domain.entity.Movie
import dev.andrewjap.nontonmovie.presentation.ui.home.HomeScreen
import dev.andrewjap.nontonmovie.presentation.ui.theme.NontonMovieTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NontonMovieTheme {
                HomeScreen(
                    movies = listOf(
                        Movie(
                            1,
                            "heloooo",
                            "https://tinyjpg.com/images/social/website.jpg",
                            "https://tinyjpg.com/images/social/website.jpg"
                        ),
                        Movie(
                            3,
                            "heloo33333",
                            "https://tinyjpg.com/images/social/website.jpg",
                            "https://tinyjpg.com/images/social/website.jpg"
                        )
                    )
                )
            }

        }
    }
}