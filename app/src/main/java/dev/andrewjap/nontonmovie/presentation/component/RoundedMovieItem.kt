package dev.andrewjap.nontonmovie.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.andrewjap.nontonmovie.domain.entity.Film
import dev.chrisbanes.accompanist.coil.CoilImage

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@Composable
fun RoundedMovieItem(
    movie: Film,
    onItemClicked: (Film) -> Unit,
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
                .background(Color.Gray)
                .clickable { onItemClicked.invoke(movie) }
        ) {
            CoilImage(
                data = movie.portraitImage,
                contentDescription = null,
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

@Preview
@Composable
fun PreviewRoundedMovieItem() {
    val movie = remember {
        Film.Movie(
            1,
            "Herooooo",
            "asd",
            "https://i.picsum.photos/id/513/200/200.jpg",
            "https://i.picsum.photos/id/513/200/200.jpg"
        )
    }
    RoundedMovieItem(
        movie = movie,
        onItemClicked = {},
        modifier = Modifier.preferredHeight(100.dp)
    )
}