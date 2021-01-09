package dev.andrewjap.nontonmovie.presentation.ui.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage
import dev.andrewjap.nontonmovie.R
import dev.andrewjap.nontonmovie.domain.entity.Movie

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@Composable
fun PortraitMovieItem(
    movie: Movie,
    onItemClicked: (Movie) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .clickable { onItemClicked.invoke(movie) }
            .padding(4.dp),
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .aspectRatio(0.75f)
                .align(Alignment.CenterHorizontally)
        ) {
            GlideImage(
                imageModel = movie.image,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .fillMaxSize()
                    .clip(MaterialTheme.shapes.small),
                placeHolder = imageResource(R.drawable.website),
                error = imageResource(R.drawable.website)
            )
        }
    }
}