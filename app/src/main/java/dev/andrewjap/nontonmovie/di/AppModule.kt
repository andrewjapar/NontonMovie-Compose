package dev.andrewjap.nontonmovie.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.andrewjap.nontonmovie.NontonMovieApp

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

@Module
@InstallIn(ApplicationComponent::class)
interface AppModule {

    @Binds
    fun bindAppContext(@ApplicationContext application: NontonMovieApp): Context
}