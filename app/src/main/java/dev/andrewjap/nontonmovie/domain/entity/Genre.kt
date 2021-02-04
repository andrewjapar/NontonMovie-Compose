package dev.andrewjap.nontonmovie.domain.entity

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

data class Genre(
    val id: Int,
    val name: String,
    val image: String = "https://www.cbronline.com/wp-content/uploads/2016/06/what-is-URL-770x503.jpg"
)