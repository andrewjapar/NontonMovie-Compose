package dev.andrewjap.nontonmovie.data.repository

import dev.andrewjap.nontonmovie.domain.entity.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getPopular(): Flow<List<Movie>>
}