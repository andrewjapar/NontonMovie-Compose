package dev.andrewjap.nontonmovie.presentation.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.Crossfade
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import dev.andrewjap.nontonmovie.R
import dev.andrewjap.nontonmovie.presentation.ui.main.home.HomeScreen
import dev.andrewjap.nontonmovie.presentation.ui.main.home.HomeViewModel
import dev.andrewjap.nontonmovie.presentation.ui.main.tv.TvShowScreen
import dev.andrewjap.nontonmovie.presentation.ui.main.tv.TvShowViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */


@Composable
fun HomeBottomNavigation(
    navController: NavHostController,
    items: List<BottomNavigationScreens>
) {
    BottomNavigation {
        val currentRoute = currentRoute(navController = navController)
        items.forEach {
            BottomNavigationItem(
                icon = { Icon(imageVector = vectorResource(id = it.iconId), contentDescription = null) },
                label = {
                    Text(
                        text = stringResource(it.resourceId),
                        fontSize = 10.sp
                    )
                },
                selected = currentRoute == it.route,
                onClick = {
                    if (currentRoute != it.route) navController.navigate(it.route) {
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@Suppress("NO_REFLECTION_IN_CLASS_PATH")
@ExperimentalCoroutinesApi
@Composable
fun MainScreenNavigationConfigurations(
    navController: NavHostController,
    homeViewModel: HomeViewModel,
    tvShowViewModel: TvShowViewModel
) {
    NavHost(navController, startDestination = BottomNavigationScreens.Home.route) {
        BottomNavigationScreens::class.sealedSubclasses
            .mapNotNull { it.objectInstance }
            .forEach { menu ->
                composable(menu.route) {
                    Contents(
                        navBackStackEntry = it,
                        homeViewModel = homeViewModel,
                        tvShowViewModel = tvShowViewModel
                    )
                }
            }
    }
}

@ExperimentalCoroutinesApi
@Composable
fun Contents(
    navBackStackEntry: NavBackStackEntry,
    homeViewModel: HomeViewModel,
    tvShowViewModel: TvShowViewModel
) {
    Crossfade(current = navBackStackEntry) {
        when (it.arguments?.getString(KEY_ROUTE)) {
            BottomNavigationScreens.Home.route -> HomeScreen(homeViewModel)
            BottomNavigationScreens.TV.route -> TvShowScreen(tvShowViewModel)
            BottomNavigationScreens.Movies.route -> HomeScreen(homeViewModel)
            BottomNavigationScreens.Sports.route -> HomeScreen(homeViewModel)
            else -> Text("UNKNOWN PAGE")
        }
    }
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString(KEY_ROUTE)
}

sealed class BottomNavigationScreens(
    val route: String,
    @StringRes val resourceId: Int,
    @DrawableRes val iconId: Int
) {
    object Home : BottomNavigationScreens("Home", R.string.lbl_home, R.drawable.ic_home)
    object TV :
        BottomNavigationScreens("TV", R.string.lbl_tv, R.drawable.ic_live_tv)

    object Movies : BottomNavigationScreens("Movies", R.string.lbl_movies, R.drawable.ic_movie)
    object Sports :
        BottomNavigationScreens("Sports", R.string.lbl_sports, R.drawable.ic_sports_soccer)
}
