package com.matdev.appcurso

sealed class ResultFood<out T> {
    data class Success<R>(val data: R): ResultFood<R>()
    data class Error(val error: Exception): ResultFood<Nothing>()
}