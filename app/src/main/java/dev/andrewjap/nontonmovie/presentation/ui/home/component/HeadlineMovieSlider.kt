package dev.andrewjap.nontonmovie.presentation.ui.home.component

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AmbientAnimationClock
import androidx.compose.ui.unit.dp
import dev.andrewjap.nontonmovie.domain.entity.Movie
import dev.andrewjap.nontonmovie.presentation.util.Pager
import dev.andrewjap.nontonmovie.presentation.util.PagerState

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@Composable
fun HeadlineMovieSlider(
    items: List<Movie>,
    modifier: Modifier = Modifier,
    onItemClicked: (Movie) -> Unit = {},
    pagerState: PagerState = run {
        val clock = AmbientAnimationClock.current
        remember(clock) { PagerState(clock) }
    }
) {
    if (items.isNotEmpty()) {
        pagerState.maxPage = (items.size - 1).coerceAtLeast(0)
        Pager(state = pagerState, modifier = modifier) {
            LandscapeMovieItem(
                movie = items[page],
                modifier = Modifier.padding(4.dp),
                onItemClicked = { onItemClicked.invoke(items[page]) }
            )
        }
    }
}