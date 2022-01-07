package com.example.travelblog

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

private const val KEY_LOGIN_STATE = "key_login_state"

class BlogPreferences ( context : Context) {
    private val preferences : SharedPreferences
        = context.getSharedPreferences("travel-blog", Context.MODE_PRIVATE)

    fun isLoggedIn() : Boolean = preferences.getBoolean(KEY_LOGIN_STATE, false)

    fun iAmTest() = Log.println(Log.INFO, "i ama tag", "I am a test" )

    fun setLoggedIn(loggedIn : Boolean) {
        preferences.edit().putBoolean(KEY_LOGIN_STATE, loggedIn).apply()
    }
}