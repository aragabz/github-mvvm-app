package com.ragabz.githubapp.base

/**
 * A generic class that holds a value with its loading status.
 *
 * Result is usually created by the Repository classes where they return
 * `LiveData<Result<T>>` to pass back the latest data to the UI with its fetch status.
 */

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error<out T>(val message: String? = "Unknown error", val data: T? = null) :
        Result<T>()
}

inline fun <reified X> Result<X>.onError(action: (String?) -> Unit): Result<X> {
    if (this is Result.Error) {
        action.invoke(this.message)
    }
    return this
}

inline fun <reified X> Result<X>.onSuccess(action: (X) -> Unit): Result<X> {
    if (this is Result.Success) {
        action.invoke(this.data)
    }
    return this
}
