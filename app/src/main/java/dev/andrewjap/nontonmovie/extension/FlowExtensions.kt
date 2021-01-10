package dev.andrewjap.nontonmovie.extension

import android.util.Log
import dev.andrewjap.nontonmovie.data.exception.InternalException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import java.io.IOException

/**
 * Designed and developed by Andrew Japar (@andrewjapar)
 *
 */

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T
): Flow<T> {
    return flow {
        emit(apiCall.invoke())
    }.catch { error ->
        throw when (error) {
            is IOException -> InternalException.NetworkError(error.localizedMessage)
            else -> error
        }
    }.flowOn(dispatcher)
}

suspend fun <T> Flow<T>.safeCollect(
    onComplete: () -> Unit = {},
    onError: (Throwable) -> Unit = { Log.d("debug", "error $it") },
    onSuccess: (T) -> Unit = {}
) {
    catch {
        onError.invoke(it)
        onComplete.invoke()
    }.collect {
        onSuccess.invoke(it)
        onComplete.invoke()
    }
}