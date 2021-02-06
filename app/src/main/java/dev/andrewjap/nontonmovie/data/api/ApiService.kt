package dev.andrewjap.nontonmovie.data.api

import dev.andrewjap.nontonmovie.data.response.*
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

interface ApiService {

    @GET("movie/now_playing?language=en-US")
    suspend fun getNowPlayingMovies(): MovieListResponse

    @GET("movie/popular?language=en-US")
    suspend fun getPopularMovies(): MovieListResponse

    @GET("movie/top_rated?language=en-US")
    suspend fun getLatestMovies(): MovieListResponse

    @GET("movie/upcoming?language=en-US")
    suspend fun getUpcomingMovies(): MovieListResponse

    @GET("movie/{id}")
    suspend fun getMovieDetails(@Path("id") movieId: Int): MovieDetailResponse

    @GET("movie/{id}/similar?language=en-US")
    suspend fun getSimilarMovie(@Path("id") movieId: Int): MovieListResponse

    @GET("movie/{id}/recommendations?language=en-US")
    suspend fun getRecommendationMovie(@Path("id") movieId: Int): MovieListResponse

    @GET("tv/popular?language=en-US")
    suspend fun getPopularTvShows(): TvShowListResponse

    @GET("tv/airing_today?language=en-US")
    suspend fun getLiveTvShows(): TvShowListResponse

    @GET("tv/top_rated?language=en-US")
    suspend fun getTopRatedTvShows(): TvShowListResponse

    @GET("tv/on_the_air?language=en-US")
    suspend fun getLatestTvShows(): TvShowListResponse

    @GET("tv/{id}")
    suspend fun getTvShowDetails(@Path("id") movieId: Int): TvShowDetailResponse

    @GET("tv/{id}/similar?language=en-US")
    suspend fun getSimilarTvShow(@Path("id") movieId: Int): TvShowListResponse

    @GET("tv/{id}/recommendations?language=en-US")
    suspend fun getRecommendationTvShow(@Path("id") movieId: Int): TvShowListResponse

    @GET("genre/movie/list?language=en-US")
    suspend fun getMovieGenre(): GenreListResponse
}