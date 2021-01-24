package dev.andrewjap.nontonmovie.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dev.andrewjap.nontonmovie.data.api.ApiService
import dev.andrewjap.nontonmovie.data.repository.MovieRepository
import dev.andrewjap.nontonmovie.data.repository.MovieRepositoryImpl
import dev.andrewjap.nontonmovie.data.repository.TvShowRepository
import dev.andrewjap.nontonmovie.data.repository.TvShowRepositoryImpl

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@Module
@InstallIn(ActivityComponent::class)
object RepositoryModule {

    @Provides
    fun provideMovieRepository(apiService: ApiService): MovieRepository {
        return MovieRepositoryImpl(apiService)
    }

    @Provides
    fun provideTvShowRepository(apiService: ApiService): TvShowRepository {
        return TvShowRepositoryImpl(apiService)
    }
}