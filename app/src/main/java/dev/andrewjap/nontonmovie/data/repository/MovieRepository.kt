package dev.andrewjap.nontonmovie.data.repository

import dev.andrewjap.nontonmovie.BuildConfig
import dev.andrewjap.nontonmovie.data.api.ApiService
import dev.andrewjap.nontonmovie.data.response.MovieDetailResponse
import dev.andrewjap.nontonmovie.data.response.MovieListResponse
import dev.andrewjap.nontonmovie.domain.entity.Film.Movie
import dev.andrewjap.nontonmovie.extension.safeApiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

interface MovieRepository {
    suspend fun getNowPlaying(): Flow<List<Movie>>
    suspend fun getLatest(): Flow<List<Movie>>
    suspend fun getPopular(): Flow<List<Movie>>
    suspend fun getUpcoming(): Flow<List<Movie>>

    suspend fun getDetail(id: Int): Flow<Movie>
    suspend fun getSimilar(id: Int): Flow<List<Movie>>
    suspend fun getRecommendation(id: Int): Flow<List<Movie>>
}

class MovieRepositoryImpl(
    private val apiService: ApiService
) : MovieRepository {

    override suspend fun getNowPlaying(): Flow<List<Movie>> {
        return safeApiCall(Dispatchers.IO) { apiService.getNowPlayingMovies().toMovieList() }
    }

    override suspend fun getLatest(): Flow<List<Movie>> {
        return safeApiCall(Dispatchers.IO) { apiService.getLatestMovies().toMovieList() }
    }

    override suspend fun getPopular(): Flow<List<Movie>> {
        return safeApiCall(Dispatchers.IO) { apiService.getPopularMovies().toMovieList() }
    }

    override suspend fun getUpcoming(): Flow<List<Movie>> {
        return safeApiCall(Dispatchers.IO) { apiService.getUpcomingMovies().toMovieList() }
    }

    override suspend fun getDetail(id: Int): Flow<Movie> {
        return safeApiCall(Dispatchers.IO) { apiService.getMovieDetails(id).toMovie() }
    }

    override suspend fun getRecommendation(id: Int): Flow<List<Movie>> {
        return safeApiCall(Dispatchers.IO) { apiService.getRecommendationMovie(id).toMovieList() }
    }

    override suspend fun getSimilar(id: Int): Flow<List<Movie>> {
        return safeApiCall(Dispatchers.IO) { apiService.getSimilarMovie(id).toMovieList() }
    }

    private fun MovieListResponse.toMovieList(): List<Movie> {
        return results?.map { it.toMovie() } ?: emptyList()
    }

    private fun MovieDetailResponse.toMovie(): Movie {
        return Movie(
            id = id,
            title = title ?: "",
            description = overview ?: "",
            portraitImage = BuildConfig.MOVIE_IMAGE_PATH + posterPath,
            landscapeImage = BuildConfig.MOVIE_IMAGE_PATH + backdropPath
        )
    }
}