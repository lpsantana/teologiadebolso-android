package com.iesb.teologiadebolso.activities.recuperasenha

import android.content.Context
import com.iesb.teologiadebolso.listener.FirebaseListener

interface RecuperaSenhaListener {


    interface Model {
        fun resetPassword(email: String, listener: FirebaseListener)
    }

    interface View {
        fun getContext(): Context
        fun showProgressAdd(isAdding: Boolean)
        fun showAlert(title: String, message: String)
    }

    interface Presenter {
        fun initContent()
        fun onRecuperarPressed(email: String)
    }

}

