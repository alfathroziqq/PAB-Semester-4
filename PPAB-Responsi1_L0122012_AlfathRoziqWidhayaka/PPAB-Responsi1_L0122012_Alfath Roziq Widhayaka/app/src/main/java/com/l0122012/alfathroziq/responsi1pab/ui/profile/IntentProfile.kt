package com.l0122012.alfathroziq.responsi1pab.ui.profile

import android.os.Bundle

class IntentProfile {
    fun getProfileBundle(): Bundle {
        val profileBundle = Bundle()
        profileBundle.putString(ProfileFragment.EXTRA_NAME, "Alfath Roziq Widhayaka")
        profileBundle.putString(ProfileFragment.EXTRA_NIM, "L0122012")
        profileBundle.putString(ProfileFragment.EXTRA_PRODI, "Informatika")
        profileBundle.putInt(ProfileFragment.EXTRA_BATCH, 2022)
        profileBundle.putString(ProfileFragment.EXTRA_FACULTY, "FATISDA")
        profileBundle.putString(ProfileFragment.EXTRA_UNIVERSITY, "Universitas Sebelas Maret")
        profileBundle.putString(ProfileFragment.EXTRA_EMAIL, "alfathroziq94@gmail.com")
        return profileBundle
    }
}
