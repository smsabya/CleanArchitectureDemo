package com.example.cleanarchdemoapp.utils

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import java.io.IOException

object ErrorUtils {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun handleException(e: Throwable): String {
        return when (e) {
            is IOException -> "Network error, please check your connection"
            is HttpException -> "Server error, please try again later"
            else -> "Unexpected error occurred"
        }
    }
}