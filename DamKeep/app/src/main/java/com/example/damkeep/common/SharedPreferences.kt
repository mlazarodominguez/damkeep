package com.example.damkeep.common

import android.content.Context
import android.content.SharedPreferences
import com.example.damkeep.di.MyApp


class SharedPreferencesManager {
    private val ctx: Context? = null
    private fun SharedPreferencesManager(ctx: Context) {}

    private fun getSharedPreferences(): SharedPreferences {
        return MyApp.instance
            .getSharedPreferences(Constants.APP_SETTINGS_FILE, Context.MODE_PRIVATE)
    }

    fun setStringValue(dataLabel: String?, dataValue: String?) {
        val editor = getSharedPreferences().edit()
        editor.putString(dataLabel, dataValue)
        editor.commit()
    }

    fun getStringValue(dataLabel: String?): String? {
        return getSharedPreferences().getString(dataLabel, null)
    }



}