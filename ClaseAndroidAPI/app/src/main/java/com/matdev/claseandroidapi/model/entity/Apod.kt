package com.matdev.claseandroidapi.model.entity


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Apod(
    var date: String = "",
    var explanation: String = "",
    var hdurl: String = "",
    var media_type: String = "",
    var service_version: String = "",
    var title: String = "",
    var url: String = ""
) : Parcelable