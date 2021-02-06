package dev.andrewjap.nontonmovie.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.andrewjap.nontonmovie.domain.entity.Film

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@Composable
fun LandscapeMovieItem(
    movie: Film,
    onItemClicked: (Film) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Box(
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1.77f)
                .align(Alignment.CenterHorizontally)
                .clip(MaterialTheme.shapes.small)
                .background(Color.Gray)
                .clickable { onItemClicked.invoke(movie) }
        ) {
            NontonMovieImage(
                data = movie.landscapeImage,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        Brush.verticalGradient(
                            listOf(Color.Transparent, Color.Black.copy(alpha = 0.75f)),
                            0f,
                            500f
                        )
                    )
            )

            Text(
                text = "${movie.title}: ${movie.description}",
                color = Color.White,
                maxLines = 1,
                fontWeight = FontWeight.Medium,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(12.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewLandscapeMovieItem() {
    val movie = remember {
        Film.Movie(
            1,
            "Herooooo",
            "asd",
            "https://www.cbronline.com/wp-content/uploads/2016/06/what-is-URL-770x503.jpg",
            "https://www.cbronline.com/wp-content/uploads/2016/06/what-is-URL-770x503.jpg"
        )
    }
    LandscapeMovieItem(
        movie = movie,
        onItemClicked = {},
        modifier = Modifier.preferredHeight(100.dp)
    )
}