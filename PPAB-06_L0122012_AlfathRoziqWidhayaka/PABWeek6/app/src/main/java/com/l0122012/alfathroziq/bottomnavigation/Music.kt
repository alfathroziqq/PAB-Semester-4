package com.l0122012.alfathroziq.bottomnavigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Music(
    val name: String,
    val desc: String,
    val img: Int
) : Parcelable