package com.example.cleanarchdemoapp.utils

import android.view.View

object ViewUtils {
    fun View.show() {
        this.visibility = View.VISIBLE
    }

    fun View.hide() {
        this.visibility = View.GONE
    }
}