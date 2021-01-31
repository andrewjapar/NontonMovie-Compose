package dev.andrewjap.nontonmovie.presentation.component

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.andrewjap.nontonmovie.R
import dev.andrewjap.nontonmovie.presentation.ui.login.TestActivity

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@Composable
fun AppDrawer(
    dismiss: () -> Unit
) {
    val context = AmbientContext.current

    Column {
        Spacer(Modifier.preferredHeight(16.dp))
        DrawerItem(
            icon = Icons.Filled.AccountCircle,
            title = stringResource(id = R.string.lbl_log_in),
            subtitle = stringResource(id = R.string.lbl_log_in_caption),
            isSelected = true,
            action = { }
        )
        Spacer(Modifier.preferredHeight(16.dp))
        DrawerItem(
            icon = Icons.Filled.Home,
            title = stringResource(id = R.string.lbl_home),
            isSelected = false,
            action = { }
        )
        DrawerItem(
            icon = Icons.Filled.Settings,
            title = stringResource(id = R.string.lbl_settings),
            isSelected = false,
            action = {
                context.startActivity(
                    Intent(context, TestActivity::class.java)
                )
                dismiss.invoke()
            }
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

    val imageAlpha = if (isSelected) 1f
    else 0.6f

    val imageSize = if (subtitle.isNullOrBlank()) 24.dp
    else 36.dp

    val rowPadding = if (subtitle.isNullOrBlank()) 6.dp
    else 0.dp

    val textIconColor = if (isSelected) colors.primary
    else colors.onSurface.copy(alpha = 0.6f)

    val backgroundColor = if (isSelected) colors.primary.copy(alpha = 0.12f)
    else Color.Transparent

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
                contentDescription = title,
                colorFilter = ColorFilter.tint(Color.White),
                alpha = imageAlpha,
                modifier = Modifier
                    .padding(rowPadding)
                    .preferredWidth(imageSize)
                    .preferredHeight(imageSize)
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

            if (!subtitle.isNullOrBlank()) {
                Spacer(Modifier.weight(1f))
                Image(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }
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