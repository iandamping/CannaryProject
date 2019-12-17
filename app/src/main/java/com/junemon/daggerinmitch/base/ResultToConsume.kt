package com.junemon.daggerinmitch.base

/*
data class ResultToConsume<out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T): ResultToConsume<T> {
            return ResultToConsume(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String, data: T? = null): ResultToConsume<T> {
            return ResultToConsume(Status.ERROR, data, message)
        }

        fun <T> loading(data: T? = null): ResultToConsume<T> {
            return ResultToConsume(Status.LOADING, data, null)
        }
    }
}*/

sealed class ResultToConsume<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : ResultToConsume<T>(data)
    class Loading<T>(data: T? = null) : ResultToConsume<T>(data)
    class Error<T>(message: String, data: T? = null) : ResultToConsume<T>(data, message)
}

