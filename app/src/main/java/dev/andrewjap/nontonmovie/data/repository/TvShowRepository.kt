package dev.andrewjap.nontonmovie.data.repository

import dev.andrewjap.nontonmovie.BuildConfig
import dev.andrewjap.nontonmovie.data.api.ApiService
import dev.andrewjap.nontonmovie.data.response.TvShowListResponse
import dev.andrewjap.nontonmovie.domain.entity.Film.TvShow
import dev.andrewjap.nontonmovie.extension.safeApiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

interface TvShowRepository {
    suspend fun getPopular(): Flow<List<TvShow>>
    suspend fun getLatest(): Flow<List<TvShow>>
    suspend fun getTopRated(): Flow<List<TvShow>>
    suspend fun getLiveToday(): Flow<List<TvShow>>
}

class TvShowRepositoryImpl(
    private val apiService: ApiService
) : TvShowRepository {

    override suspend fun getLatest(): Flow<List<TvShow>> {
        return safeApiCall(Dispatchers.IO) { apiService.getLatestTvShows().toTvShowList() }
    }

    override suspend fun getLiveToday(): Flow<List<TvShow>> {
        return safeApiCall(Dispatchers.IO) { apiService.getLiveTvShows().toTvShowList() }
    }

    override suspend fun getPopular(): Flow<List<TvShow>> {
        return safeApiCall(Dispatchers.IO) { apiService.getPopularTvShows().toTvShowList() }
    }

    override suspend fun getTopRated(): Flow<List<TvShow>> {
        return safeApiCall(Dispatchers.IO) { apiService.getTopRatedTvShows().toTvShowList() }
    }

    private fun TvShowListResponse.toTvShowList(): List<TvShow> {
        return results?.map {
            TvShow(
                id = it.id,
                title = it.name ?: "",
                description = it.overview ?: "",
                portraitImage = BuildConfig.MOVIE_IMAGE_PATH + it.posterPath,
                landscapeImage = BuildConfig.MOVIE_IMAGE_PATH + it.backdropPath

            )
        } ?: emptyList()
    }
}