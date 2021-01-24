package dev.andrewjap.nontonmovie.presentation.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import dev.andrewjap.nontonmovie.R
import dev.andrewjap.nontonmovie.presentation.component.AppDrawer
import dev.andrewjap.nontonmovie.presentation.component.BottomNavigationScreens
import dev.andrewjap.nontonmovie.presentation.component.HomeBottomNavigation
import dev.andrewjap.nontonmovie.presentation.component.MainScreenNavigationConfigurations
import dev.andrewjap.nontonmovie.presentation.ui.main.home.HomeViewModel
import dev.andrewjap.nontonmovie.presentation.ui.main.tv.TvShowViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@ExperimentalCoroutinesApi
@Composable
fun MainScreen(
    homeViewModel: HomeViewModel,
    tvShowViewModel: TvShowViewModel
) {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            AppDrawer(
                dismiss = scaffoldState.drawerState::close
            )
        },
        bottomBar = {
            HomeBottomNavigation(
                navController = navController,
                items = listOf(
                    BottomNavigationScreens.Home,
                    BottomNavigationScreens.TV,
                    BottomNavigationScreens.Movies,
                    BottomNavigationScreens.Sports
                )
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) },
                backgroundColor = Color.Transparent,
                navigationIcon = {
                    IconButton(onClick = { scaffoldState.drawerState.open() }) {
                        Icon(imageVector = Icons.Outlined.Menu)
                    }
                }
            )

            MainScreenNavigationConfigurations(
                navController = navController,
                homeViewModel = homeViewModel,
                tvShowViewModel = tvShowViewModel
            )
        }
    }
}