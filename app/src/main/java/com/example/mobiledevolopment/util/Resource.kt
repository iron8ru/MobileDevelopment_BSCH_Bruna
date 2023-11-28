package com.example.mobiledevolopment.util

sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error<out T>(val throwable: Throwable, val msg: String? = null, val data: T? = null) :
        Resource<T>()
    object Loading : Resource<Nothing>()
}