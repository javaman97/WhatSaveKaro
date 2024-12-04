package com.statussaver.whatsavekaro.utils

import android.content.Context
import android.content.SharedPreferences

class Preferences(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val PREFERENCES_NAME = "Settings"
        private const val KEY_SELECTED_LANGUAGE = "selectedLanguage"
    }

    // Get the selected language
    fun getSelectedLanguage(): String {
        return sharedPreferences.getString(KEY_SELECTED_LANGUAGE, "English") ?: "English"
    }

    // Save the selected language
    fun setSelectedLanguage(language: String) {
        sharedPreferences.edit().putString(KEY_SELECTED_LANGUAGE, language).apply()
    }
}
