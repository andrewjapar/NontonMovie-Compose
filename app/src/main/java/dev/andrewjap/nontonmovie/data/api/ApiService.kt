package dev.andrewjap.nontonmovie.data.api

import dev.andrewjap.nontonmovie.data.response.MovieDetailResponse
import dev.andrewjap.nontonmovie.data.response.MovieListResponse
import dev.andrewjap.nontonmovie.data.response.TvShowListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

interface ApiService {

    @GET("movie/now_playing?language=en-US")
    suspend fun getNowPlayingMovies(): MovieListResponse

    @GET("movie/popular?language=en-US")
    suspend fun getPopularMovies(@Query("page") page: Int): MovieListResponse

    @GET("movie/{id}")
    suspend fun getMovieDetails(@Path("id") movieId: Int): MovieDetailResponse

    @GET("tv/popular?language=en-US")
    suspend fun getPopularTvShows(): TvShowListResponse

    @GET("tv/airing_today?language=en-US")
    suspend fun getLiveTvShows(): TvShowListResponse

    @GET("tv/top_rated?language=en-US")
    suspend fun getTopRatedTvShows(): TvShowListResponse

    @GET("tv/latest?language=en-US")
    suspend fun getLatestTvShows(): TvShowListResponse
}