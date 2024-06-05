package com.l0122012.alfathroziq.responsi1pab.ui.facility

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sarana(
    val name: String,
    val desc: String,
    val img: Int
) : Parcelable