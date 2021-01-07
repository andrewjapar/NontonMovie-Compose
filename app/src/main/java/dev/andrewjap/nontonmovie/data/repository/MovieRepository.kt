package dev.andrewjap.nontonmovie.data.repository

import dev.andrewjap.nontonmovie.data.api.MovieService

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

interface MovieRepository {
}

class MovieRepositoryImpl(private val movieService: MovieService) : MovieRepository