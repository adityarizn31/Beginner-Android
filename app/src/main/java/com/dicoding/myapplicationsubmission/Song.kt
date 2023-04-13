package com.dicoding.myapplicationsubmission

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Song(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
