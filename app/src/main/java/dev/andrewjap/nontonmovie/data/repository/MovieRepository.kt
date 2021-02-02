package dev.andrewjap.nontonmovie.data.repository

import dev.andrewjap.nontonmovie.BuildConfig
import dev.andrewjap.nontonmovie.data.api.ApiService
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

    private fun MovieListResponse.toMovieList(): List<Movie> {
        return results?.map {
            Movie(
                id = it.id,
                title = it.title ?: "",
                description = it.overview ?: "",
                portraitImage = BuildConfig.MOVIE_IMAGE_PATH + it.posterPath,
                landscapeImage = BuildConfig.MOVIE_IMAGE_PATH + it.backdropPath
            )
        } ?: emptyList()
    }
}