package com.bangkit.myfield.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
    var token: String? = ""
        ): Parcelable
