package dev.andrewjap.nontonmovie.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dev.andrewjap.nontonmovie.data.api.MovieService
import dev.andrewjap.nontonmovie.data.repository.MovieRepository
import dev.andrewjap.nontonmovie.data.repository.MovieRepositoryImpl

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@Module
@InstallIn(ActivityComponent::class)
object RepositoryModule {

    @Provides
    fun provideMovieRepository(movieService: MovieService): MovieRepository {
        return MovieRepositoryImpl(movieService)
    }
}