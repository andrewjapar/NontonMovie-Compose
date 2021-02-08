package dev.andrewjap.nontonmovie.data.repository

import dev.andrewjap.nontonmovie.BuildConfig
import dev.andrewjap.nontonmovie.data.api.ApiService
import dev.andrewjap.nontonmovie.data.response.TvShowDetailResponse
import dev.andrewjap.nontonmovie.data.response.TvShowListResponse
import dev.andrewjap.nontonmovie.domain.entity.Film
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

    suspend fun getDetails(id: Int): Flow<TvShow>
    suspend fun getSimilar(id: Int): Flow<List<TvShow>>
    suspend fun getRecommendation(id: Int): Flow<List<TvShow>>
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

    override suspend fun getDetails(id: Int): Flow<TvShow> {
        return safeApiCall(Dispatchers.IO) { apiService.getTvShowDetails(id).toTvShow() }
    }

    override suspend fun getSimilar(id: Int): Flow<List<TvShow>> {
        return safeApiCall(Dispatchers.IO) { apiService.getSimilarTvShow(id).toTvShowList() }
    }

    override suspend fun getRecommendation(id: Int): Flow<List<TvShow>> {
        return safeApiCall(Dispatchers.IO) { apiService.getRecommendationTvShow(id).toTvShowList() }
    }

    private fun TvShowListResponse.toTvShowList(): List<TvShow> {
        return results?.map { it.toTvShow() } ?: emptyList()
    }

    private fun TvShowDetailResponse.toTvShow(): Film.TvShow {
        return TvShow(
            id = id,
            title = name ?: "",
            description = overview ?: "",
            portraitImage = BuildConfig.MOVIE_IMAGE_PATH + posterPath,
            landscapeImage = BuildConfig.MOVIE_IMAGE_PATH + backdropPath,
            genres = genres?.take(3)?.mapNotNull { it.name } ?: emptyList()
        )
    }
}