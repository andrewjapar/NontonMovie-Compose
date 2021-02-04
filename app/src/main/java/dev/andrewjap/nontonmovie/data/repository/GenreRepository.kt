package dev.andrewjap.nontonmovie.data.repository

import dev.andrewjap.nontonmovie.data.api.ApiService
import dev.andrewjap.nontonmovie.domain.entity.Genre
import dev.andrewjap.nontonmovie.extension.safeApiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

interface GenreRepository {
    suspend fun getMovieGenre(): Flow<List<Genre>>
}

class GenreRepositoryImpl(
    private val apiService: ApiService
) : GenreRepository {

    override suspend fun getMovieGenre(): Flow<List<Genre>> {
        return safeApiCall(Dispatchers.IO) {
            apiService.getMovieGenre().genres.map {
                Genre(
                    id = it.id,
                    name = it.name ?: ""
                )
            }
        }
    }
}