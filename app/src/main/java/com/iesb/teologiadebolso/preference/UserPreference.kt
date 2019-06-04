package com.iesb.teologiadebolso.preference

import android.content.Context
import android.content.SharedPreferences

class UserPreference(private val context: Context) {
    private val FILE_NAME = "com.iesb.teologiadebolso.preference"
    private val USER_LOGIN_KEY = "USER_LOGIN_KEY"
    private val ONBOARDING = "ONBOARDING"
    private lateinit var preference: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    init {
        preference = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        editor = preference.edit()
    }

    fun saveUser(email: String){
        editor.putString(USER_LOGIN_KEY, email)
        editor.commit()
    }

    fun getCurrentUser(): String{
        return preference.getString(USER_LOGIN_KEY, null)
    }

    fun isLogged(): Boolean {
        if (getCurrentUser() == null){
            return false
        }
        return true
    }

    fun logout(){
        editor.clear()
        editor.commit()
    }

    fun saveOnBoarding(){
        editor.putBoolean(ONBOARDING, true)
        editor.commit()
    }

    fun onboardingViewed():Boolean{
        return preference.getBoolean(ONBOARDING, false)
    }
}