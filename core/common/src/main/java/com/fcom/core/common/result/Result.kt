package com.fcom.core.common.result

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

sealed interface Result<out T> {
    data class Success<T>(val data: T) : Result<T>
    data class Error(val throwable: Throwable) : Result<Nothing>
    data object Loading : Result<Nothing>
}

/** Transform a flow of type [T] into a flow of type Result<T>
 * This extension function takes a flow of type [T], wraps each emitted item into a [Result.Success]
 * emits a [Result.Loading] item at the start,
 * and converts any errors into [Result.Error] objects. */
fun <T> Flow<T>.asResult(): Flow<Result<T>> = map<T, Result<T>> { Result.Success(it) }
    .onStart { emit(Result.Loading) }
    .catch { emit(Result.Error(it)) }