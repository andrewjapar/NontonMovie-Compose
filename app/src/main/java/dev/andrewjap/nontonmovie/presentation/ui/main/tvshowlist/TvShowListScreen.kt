package dev.andrewjap.nontonmovie.presentation.ui.main.tvshowlist

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

@ExperimentalCoroutinesApi
@Composable
fun TvShowScreen(
    viewModel: TvShowListViewModel = viewModel(),
    onFilmClicked: (Film) -> Unit = {},
) {

    val viewState by viewModel.showTvShows.collectAsState()

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
                items = viewState.liveTodayTvShow,
                onItemClicked = onFilmClicked,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
                    .preferredHeight(boxWidth.div(1.77f))
            )

            HorizontalMovieList(
                items = viewState.popularTvShow,
                title = "Popular TV Shows",
                onItemClicked = onFilmClicked,
                paddingContent = 8.dp,
                type = HorizontalMovieListType.LANDSCAPE,
                height = boxWidth
                    .div(3)
                    .div(0.8f)
            )

            HorizontalMovieList(
                items = viewState.topRatedTvShow,
                title = "Top Rated TV Shows",
                onItemClicked = onFilmClicked,
                paddingContent = 8.dp,
                height = boxWidth
                    .div(3)
                    .div(0.8f)
            )

            HorizontalMovieList(
                items = viewState.latestTvShow,
                title = "Latest TV Shows",
                onItemClicked = onFilmClicked,
                paddingContent = 8.dp,
                height = boxWidth
                    .div(3)
                    .div(0.8f)
            )
        }
    }
}