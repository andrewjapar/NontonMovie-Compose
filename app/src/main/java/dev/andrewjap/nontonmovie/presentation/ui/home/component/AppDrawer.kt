package dev.andrewjap.nontonmovie.presentation.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@Composable
fun AppDrawer() {
    Column {
        DrawerItem(
            icon = Icons.Filled.AccountCircle,
            title = "Log in",
            subtitle = "For a better experience",
            isSelected = true,
            action = { }
        )

        DrawerItem(
            icon = Icons.Filled.Settings,
            title = "Settings",
            isSelected = false,
            action = { }
        )
    }
}

@Composable
fun DrawerItem(
    icon: ImageVector,
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    isSelected: Boolean = false,
    action: () -> Unit = {},
) {
    val colors = MaterialTheme.colors
    val imageAlpha = if (isSelected) {
        1f
    } else {
        0.6f
    }
    val textIconColor = if (isSelected) {
        colors.primary
    } else {
        colors.onSurface.copy(alpha = 0.6f)
    }
    val backgroundColor = if (isSelected) {
        colors.primary.copy(alpha = 0.12f)
    } else {
        Color.Transparent
    }

    val surfaceModifier = modifier
        .padding(8.dp)
        .fillMaxWidth()

    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier.clickable(onClick = action)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = surfaceModifier
        ) {
            Image(
                imageVector = icon,
                colorFilter = ColorFilter.tint(textIconColor),
                alpha = imageAlpha,
                modifier = Modifier
                    .preferredWidth(36.dp)
                    .preferredHeight(36.dp)
            )
            Spacer(Modifier.preferredWidth(12.dp))
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.subtitle2
                )

                if (!subtitle.isNullOrBlank()) {
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.caption
                    )
                }
            }
            Spacer(Modifier.weight(1f))
            Image(imageVector = Icons.Default.KeyboardArrowRight)
        }
    }
}

@Preview("Drawer contents")
@Composable
fun PreviewDrawerItem() {
    DrawerItem(
        icon = Icons.Filled.AccountCircle,
        title = "Log in",
        subtitle = "For a better experience",
        isSelected = false,
        action = { }
    )
}