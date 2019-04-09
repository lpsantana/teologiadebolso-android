package com.iesb.teologiadebolso.activities.login

import android.content.Context
import com.iesb.teologiadebolso.listener.FirebaseListener

interface LoginListener {

    interface Model {
        fun login(email: String, password: String, listener: FirebaseListener)
        fun saveUser(email: String)
    }

    interface View {
        fun getContext(): Context
        fun showProgressLogin(isAdding: Boolean)
        fun goToHome()
        fun goToAddUser()
        fun goToResetPassword()
        fun showAlert(title: String, message: String)
    }

    interface Presenter {
        fun initContent()
        fun onLoginPressed(email: String, password: String)
    }
}