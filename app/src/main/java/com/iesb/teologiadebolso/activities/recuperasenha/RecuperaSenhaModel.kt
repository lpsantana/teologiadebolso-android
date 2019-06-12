package com.iesb.teologiadebolso.activities.recuperasenha

import android.app.Activity
import com.google.firebase.auth.FirebaseAuth
import com.iesb.teologiadebolso.listener.FirebaseListener

class RecuperaSenhaModel(private val activity: Activity) : RecuperaSenhaListener.Model {


    override fun resetPassword(email: String, listener: FirebaseListener) {
        val auth = FirebaseAuth.getInstance()

        auth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
            if(task.isSuccessful){
                listener.onSuccess(email)
            }else{
                listener.onFail()
            }
        }
    }


}