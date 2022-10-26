package com.polish.alertnews.common.utils.resource

sealed class Resource<out T>(val datas: T? = null, val messages: String? = null) {
    data class Success<T>(val data: T) : Resource<T>(data)
    data class Error<T>(val message: String, val data: T? = null) : Resource<T>(null, message)
    data class Loading<T>(val data: T? = null) : Resource<T>()
}
