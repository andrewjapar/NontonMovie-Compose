package dev.andrewjap.nontonmovie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import dagger.hilt.android.AndroidEntryPoint
import dev.andrewjap.nontonmovie.domain.entity.Movie
import dev.andrewjap.nontonmovie.presentation.ui.home.HomeScreen

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen(
                movies = listOf(
                    Movie(1, "heloooo", "https://tinyjpg.com/images/social/website.jpg"),
                    Movie(3, "heloo33333", "https://tinyjpg.com/images/social/website.jpg")
                )
            )
        }
    }
}