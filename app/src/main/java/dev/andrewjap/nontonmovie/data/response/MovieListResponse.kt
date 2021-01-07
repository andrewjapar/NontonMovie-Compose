package dev.andrewjap.nontonmovie.data.response

import com.google.gson.annotations.SerializedName

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

data class MovieListResponse(

    @SerializedName("page")
    val page: Int? = null,

    @SerializedName("results")
    val results: List<MovieDetailResponse>? = null,

    @SerializedName("total_pages")
    val totalPages: Int? = null,

    @SerializedName("total_results")
    val totalResults: Int? = null
)