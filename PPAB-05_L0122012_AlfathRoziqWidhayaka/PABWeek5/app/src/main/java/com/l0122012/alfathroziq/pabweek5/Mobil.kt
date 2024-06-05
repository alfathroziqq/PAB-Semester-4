package com.l0122012.alfathroziq.pabweek5

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Mobil(
    val name: String,
    val desc: String,
    val img: Int
) : Parcelable