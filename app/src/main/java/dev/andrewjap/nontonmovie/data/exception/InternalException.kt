package dev.andrewjap.nontonmovie.data.exception

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */
sealed class InternalException : Throwable() {

    data class ServerError(val code: Int, override val message: String? = null) : InternalException()
    data class ClientError(val code: Int, override val message: String? = null) : InternalException()

    data class NetworkError(override val message: String? = null) : InternalException()
}