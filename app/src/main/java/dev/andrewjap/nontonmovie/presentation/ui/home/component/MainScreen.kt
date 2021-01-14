package dev.andrewjap.nontonmovie.presentation.ui.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import dev.andrewjap.nontonmovie.R
import dev.andrewjap.nontonmovie.presentation.ui.home.HomeViewModel
import dev.andrewjap.nontonmovie.presentation.ui.home.Screen
import dev.andrewjap.nontonmovie.presentation.util.BottomNavigationScreens
import dev.andrewjap.nontonmovie.presentation.util.HomeBottomNavigation
import dev.andrewjap.nontonmovie.presentation.util.MainScreenNavigationConfigurations
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@ExperimentalCoroutinesApi
@Composable
fun MainScreen(
    homeViewModel: HomeViewModel,
    navigateTo: (Screen) -> Unit
) {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            AppDrawer(
                navigateTo = navigateTo
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
    ) {
        Column {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) },
                navigationIcon = {
                    IconButton(onClick = { scaffoldState.drawerState.open() }) {
                        Icon(imageVector = Icons.Outlined.Menu)
                    }
                }
            )

            MainScreenNavigationConfigurations(
                navController = navController,
                viewModel = homeViewModel
            )
        }
    }
}