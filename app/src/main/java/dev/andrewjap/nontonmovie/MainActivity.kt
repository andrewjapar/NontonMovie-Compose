package dev.andrewjap.nontonmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.ui.platform.setContent
import dev.andrewjap.nontonmovie.domain.entity.Movie
import dev.andrewjap.nontonmovie.presentation.ui.home.HomeScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen(movies = listOf(Movie(1, "heloo", ""), Movie(3, "heloo33333", "")) )
        }
    }
}