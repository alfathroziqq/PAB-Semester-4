package com.l0122012.alfathroziq.ppab_10_l0122012_alfathroziqwidhayaka

import android.content.Context

internal class UserPreference(context: Context) {
    companion object {
        private const val PREFS_NAME = "user_pref"
        private const val NAME = "name"
        private const val EMAIL = "email"
        private const val AGE = "age"
        private const val PHONE_NUMBER = "phone"
        private const val GENDER = "isgender"
        private const val PROFILE_PICTURE_URL = "profile_picture_url"
    }

    private val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun setUser(value: UserModel) {
        val editor = preferences.edit()
        editor.putString(NAME, value.name)
        editor.putString(EMAIL, value.email)
        editor.putInt(AGE, value.age)
        editor.putString(PHONE_NUMBER, value.phoneNumber)
        editor.putBoolean(GENDER, value.isGender)
        editor.putString(PROFILE_PICTURE_URL, value.profilePictureUrl)
        editor.apply()
    }

    fun getUser(): UserModel {
        val model = UserModel()
        model.name = preferences.getString(NAME, "")
        model.email = preferences.getString(EMAIL, "")
        model.age = preferences.getInt(AGE, 0)
        model.phoneNumber = preferences.getString(PHONE_NUMBER, "")
        model.isGender = preferences.getBoolean(GENDER, false)
        model.profilePictureUrl = preferences.getString(PROFILE_PICTURE_URL, "")
        return model
    }
}