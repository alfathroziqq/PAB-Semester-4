package com.l0122012.alfathroziq.tablayoutpab7

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cat(
    val name: String,
    val desc: String,
    val img: Int
) : Parcelable