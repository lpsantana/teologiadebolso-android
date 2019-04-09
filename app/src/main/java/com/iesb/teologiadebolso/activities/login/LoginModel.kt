package com.iesb.teologiadebolso.activities.login

import android.app.Activity
import com.google.firebase.auth.FirebaseAuth
import com.iesb.teologiadebolso.listener.FirebaseListener
import com.iesb.teologiadebolso.preference.UserPreference

class LoginModel(private val activity: Activity,
                 private val preference: UserPreference = UserPreference(activity)
                ): LoginListener.Model {

    override fun login(email: String, password: String, listener: FirebaseListener) {
        val auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(activity){
                task ->
            if(task.isSuccessful){
                listener.onSuccess(email)
            }else{
                listener.onFail()
            }
        }
    }

    override fun saveUser(email: String) {
        preference.saveUser(email)
    }
}