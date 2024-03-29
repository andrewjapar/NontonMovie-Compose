package dev.andrewjap.nontonmovie.presentation.ui.main.movielist

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AmbientDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import dev.andrewjap.nontonmovie.domain.entity.Film
import dev.andrewjap.nontonmovie.presentation.component.HeadlineMovieSlider
import dev.andrewjap.nontonmovie.presentation.component.HorizontalMovieList
import dev.andrewjap.nontonmovie.presentation.component.HorizontalMovieListType
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@ExperimentalCoroutinesApi
@Composable
fun MovieListScreen(
    viewModel: MovieListViewModel = viewModel(),
    onFilmClicked: (Film) -> Unit = {}
) {

    val viewState by viewModel.showMovies.collectAsState()

    if (viewState.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
        return
    }

    BoxWithConstraints {
        val boxWidth = with(AmbientDensity.current) { constraints.maxWidth.toDp() }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {

            HeadlineMovieSlider(
                items = viewState.nowPlaying,
                onItemClicked = onFilmClicked,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
                    .preferredHeight(boxWidth.div(1.77f))
            )

            HorizontalMovieList(
                items = viewState.upcoming,
                title = "Upcoming Movies",
                onItemClicked = onFilmClicked,
                type = HorizontalMovieListType.ROUNDED,
                paddingContent = 8.dp
            )

            HorizontalMovieList(
                items = viewState.latest,
                title = "Top Rated Movies",
                onItemClicked = onFilmClicked,
                paddingContent = 8.dp,
                type = HorizontalMovieListType.LANDSCAPE,
                height = boxWidth
                    .div(3)
                    .div(0.8f)
            )

            HorizontalMovieList(
                items = viewState.popular,
                title = "Popular Movies",
                onItemClicked = onFilmClicked,
                paddingContent = 8.dp,
                height = boxWidth
                    .div(3)
                    .div(0.8f)
            )
        }
    }
}