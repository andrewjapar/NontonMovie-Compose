package dev.andrewjap.nontonmovie.presentation.ui.filmdetail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AmbientDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import dev.andrewjap.nontonmovie.domain.entity.Film
import dev.andrewjap.nontonmovie.presentation.component.NontonMovieImage
import dev.andrewjap.nontonmovie.presentation.component.PortraitMovieItem
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@ExperimentalCoroutinesApi
@Composable
fun FilmDetailScreen(
    viewModel: FilmDetailViewModel = viewModel()
) {

    val viewState by viewModel.showDetails.collectAsState()
    val details = viewState.details

    if (viewState.isLoading || details == null) {
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
            NontonMovieImage(
                data = details.landscapeImage,
                modifier = Modifier
                    .fillMaxWidth()
                    .preferredHeight(boxWidth.div(1.77f))
            )

            FilmDescription(film = details)
        }
    }
}

@Composable
private fun FilmDescription(
    film: Film,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(modifier = modifier.wrapContentHeight()) {
        val (posterImage, title, description) = createRefs()

        PortraitMovieItem(
            movie = film,
            onItemClicked = { },
            modifier = Modifier
                .constrainAs(posterImage) {
                    width = Dimension.percent(0.4f)
                    height = Dimension.wrapContent
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
        )

        Text(
            text = film.title,
            modifier = Modifier.constrainAs(title) {
                start.linkTo(posterImage.end, margin = 8.dp)
                top.linkTo(posterImage.top)
                end.linkTo(parent.end)
            }
        )

        Text(
            text = film.description,
            modifier = Modifier.constrainAs(description) {
                width = Dimension.fillToConstraints
                top.linkTo(posterImage.bottom, margin = 8.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
        )
    }
}

@Preview
@Composable
fun PreviewFilmDescription() {
    val film = remember {
        Film.Movie(
            id = 10,
            title = "We are the champion",
            description = "Here we are the champion",
            portraitImage = "https://i.picsum.photos/id/513/200/200.jpg",
            landscapeImage = "https://i.picsum.photos/id/513/200/200.jpg"
        )
    }

    FilmDescription(film = film)
}