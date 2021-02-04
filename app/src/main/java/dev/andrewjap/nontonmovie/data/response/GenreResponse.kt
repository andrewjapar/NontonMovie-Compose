package dev.andrewjap.nontonmovie.data.response

import com.google.gson.annotations.SerializedName

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */
data class GenreResponse(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String? = null
)

data class GenreListResponse(
    @SerializedName("genres")
    val genres: List<GenreResponse>
)