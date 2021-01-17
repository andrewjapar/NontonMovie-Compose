package dev.andrewjap.nontonmovie.presentation.ui.home.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.andrewjap.nontonmovie.domain.entity.Movie
import dev.chrisbanes.accompanist.glide.GlideImage

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@Composable
fun RoundedMovieItem(
    movie: Movie,
    onItemClicked: (Movie) -> Unit,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier
            .preferredWidth(84.dp)
    ) {

        val (imageBox, titleText) = createRefs()
        Box(
            modifier = Modifier
                .constrainAs(imageBox) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }
                .aspectRatio(1f)
                .border(BorderStroke(1.dp, Color.Blue), CircleShape)
                .clip(CircleShape)
                .clickable { onItemClicked.invoke(movie) }
        ) {
            GlideImage(
                data = movie.portraitImage,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        Text(
            text = movie.title,
            color = Color.White,
            maxLines = 1,
            fontSize = 12.sp,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .constrainAs(titleText) {
                    start.linkTo(imageBox.start)
                    end.linkTo(imageBox.end)
                    bottom.linkTo(parent.bottom)
                    top.linkTo(imageBox.bottom, margin = 8.dp)
                }
        )
    }
}