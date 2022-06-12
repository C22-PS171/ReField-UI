package com.bangkit.myfield.model

import android.content.Context

internal class UserPreferences (context: Context){
    private val preference = context.getSharedPreferences(USER_PREFERENCE, Context.MODE_PRIVATE)

    fun setUsers(value: User){
        val editor = preference.edit()
        editor.putString(TOKEN, value.token)
        editor.apply()
    }
    companion object {
        private const val USER_PREFERENCE = "user_preference"
        private const val TOKEN = "token"
    }
}