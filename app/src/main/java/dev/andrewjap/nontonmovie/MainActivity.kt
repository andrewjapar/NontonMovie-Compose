package dev.andrewjap.nontonmovie

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.ui.platform.setContent
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.andrewjap.nontonmovie.presentation.ui.home.HomeViewModel
import dev.andrewjap.nontonmovie.presentation.ui.theme.NontonMovieTheme
import dev.andrewjap.nontonmovie.presentation.util.BottomNavigationScreens
import dev.andrewjap.nontonmovie.presentation.util.HomeBottomNavigation
import dev.andrewjap.nontonmovie.presentation.util.MainScreenNavigationConfigurations
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NontonMovieTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        HomeBottomNavigation(
                            navController = navController, items = listOf(
                                BottomNavigationScreens.Home,
                                BottomNavigationScreens.TV,
                                BottomNavigationScreens.Movies,
                                BottomNavigationScreens.Sports
                            )
                        )
                    }
                ) {
                    Column {
                        TopAppBar(
                            title = { Text(text = "AppBar") },
                            navigationIcon = {
                                IconButton(
                                    onClick = { /* todo */ }
                                ) {
                                    Icon(
                                        imageVector = Icons.Outlined.Menu
                                    )
                                }
                            }
                        )

                        MainScreenNavigationConfigurations(
                            navController = navController,
                            viewModel = viewModel
                        )
                    }
                }
            }
        }
    }
}