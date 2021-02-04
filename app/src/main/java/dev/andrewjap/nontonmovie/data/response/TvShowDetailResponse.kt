package dev.andrewjap.nontonmovie.data.response

import com.google.gson.annotations.SerializedName

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

data class TvShowDetailResponse(

    @SerializedName("id")
    val id: Int,

    @SerializedName("backdrop_path")
    val backdropPath: String? = null,

    @SerializedName("genres")
    val genres: List<GenreResponse>? = null,

    @SerializedName("original_language")
    val originalLanguage: String? = null,

    @SerializedName("original_name")
    val originalTitle: String? = null,

    @SerializedName("overview")
    val overview: String? = null,

    @SerializedName("popularity")
    val popularity: Double? = null,

    @SerializedName("poster_path")
    val posterPath: String? = null,

    @SerializedName("first_air_date")
    val firstAirDate: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("vote_average")
    val voteAverage: Double? = null,

    @SerializedName("vote_count")
    val voteCount: Int? = null
)