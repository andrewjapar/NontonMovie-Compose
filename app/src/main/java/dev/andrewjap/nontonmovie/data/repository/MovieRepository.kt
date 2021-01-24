package dev.andrewjap.nontonmovie.data.repository

import dev.andrewjap.nontonmovie.BuildConfig
import dev.andrewjap.nontonmovie.data.api.ApiService
import dev.andrewjap.nontonmovie.domain.entity.Film.Movie
import dev.andrewjap.nontonmovie.extension.safeApiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

interface MovieRepository {
    suspend fun get(): Flow<List<Movie>>
}

class MovieRepositoryImpl(
    private val apiService: ApiService
) : MovieRepository {

    override suspend fun get(): Flow<List<Movie>> {
        return safeApiCall(Dispatchers.IO) {
            apiService.getNowPlayingMovies().results?.map {
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
}