package dev.andrewjap.nontonmovie.presentation.ui.home

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.WithConstraints
import androidx.compose.ui.platform.AmbientDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import dev.andrewjap.nontonmovie.domain.entity.Movie
import dev.andrewjap.nontonmovie.presentation.ui.home.component.HeadlineMovieSlider
import dev.andrewjap.nontonmovie.presentation.ui.home.component.HorizontalMovieList
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel()
) {

    val viewState by viewModel.showMovies.collectAsState()

    WithConstraints {
        val boxWidth = with(AmbientDensity.current) { constraints.maxWidth.toDp() }

        ScrollableColumn(
            modifier = Modifier.fillMaxWidth()
        ) {

            HeadlineMovieSlider(
                items = viewState.popularMovies,
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                    .fillMaxWidth()
                    .preferredHeight(boxWidth.div(1.77f))
            )

            HorizontalMovieList(
                items = viewState.popularMovies,
                title = "Popular Shows",
                paddingContent = 8.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .preferredHeight(
                        boxWidth
                            .div(3)
                            .div(0.72f)
                    )
            )

            HorizontalMovieList(
                items = viewState.popularMovies,
                title = "Hello World",
                paddingContent = 8.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .preferredHeight(
                        boxWidth
                            .div(3)
                            .div(0.72f)
                    )
            )

            HorizontalMovieList(
                items = viewState.popularMovies,
                title = "Hello World",
                paddingContent = 8.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .preferredHeight(
                        boxWidth
                            .div(3)
                            .div(0.72f)
                    )
            )
        }
    }
}