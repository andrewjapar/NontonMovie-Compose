package dev.andrewjap.nontonmovie.presentation.util

import androidx.annotation.StringRes
import androidx.compose.animation.Crossfade
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import dev.andrewjap.nontonmovie.R
import dev.andrewjap.nontonmovie.presentation.ui.home.HomeScreen
import dev.andrewjap.nontonmovie.presentation.ui.home.HomeViewModel
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
                icon = { Icon(imageVector = it.icon) },
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
    viewModel: HomeViewModel
) {
    NavHost(navController, startDestination = BottomNavigationScreens.Home.route) {
        BottomNavigationScreens::class.sealedSubclasses
            .mapNotNull { it.objectInstance }
            .forEach { menu ->
                composable(menu.route) {
                    Contents(navBackStackEntry = it, viewModel = viewModel)
                }
            }
    }
}

@ExperimentalCoroutinesApi
@Composable
fun Contents(navBackStackEntry: NavBackStackEntry, viewModel: HomeViewModel) {
    Crossfade(current = navBackStackEntry) {
        when (it.arguments?.getString(KEY_ROUTE)) {
            BottomNavigationScreens.Home.route -> HomeScreen(viewModel)
            BottomNavigationScreens.TV.route -> HomeScreen(viewModel)
            BottomNavigationScreens.Movies.route -> HomeScreen(viewModel)
            BottomNavigationScreens.Sports.route -> HomeScreen(viewModel)
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
    val icon: ImageVector
) {
    object Home : BottomNavigationScreens("Home", R.string.lbl_home, Icons.Filled.Face)
    object TV : BottomNavigationScreens("TV", R.string.lbl_tv, Icons.Filled.AccountBox)
    object Movies : BottomNavigationScreens("Movies", R.string.lbl_movies, Icons.Filled.Send)
    object Sports : BottomNavigationScreens("Sports", R.string.lbl_sports, Icons.Filled.DateRange)
}