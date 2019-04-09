package com.iesb.teologiadebolso.activities.cadastro

import android.content.Context
import com.iesb.teologiadebolso.listener.FirebaseListener

interface CadastraListener {

    interface Model {
        fun createUser(email: String, password: String, listener: FirebaseListener)
        fun saveUser(email: String)
    }

    interface View {
        fun getContext(): Context
        fun showProgressAdd(isAdding: Boolean)
        fun nextView()
        fun showAlert(title: String, message: String)
    }

    interface Presenter {
        fun initContent()
        fun onAddPressed(email: String, password: String)
    }
}