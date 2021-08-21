package com.matdev.claseandroidapi

sealed class ResulNasa<out T> {
    data class Success<R>(val data: R): ResulNasa<R>()
    data class Error(val error: Exception): ResulNasa<Nothing>()
}