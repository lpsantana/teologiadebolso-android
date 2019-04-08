package com.iesb.teologiadebolso.activities.cadastro

import android.app.Activity
import com.google.firebase.auth.FirebaseAuth
import com.iesb.teologiadebolso.listener.CreateUserListener
import com.iesb.teologiadebolso.preference.UserPreference

class CadastraModel(private val activity: Activity,
                    private val preference: UserPreference = UserPreference(activity)): CadastraListener.Model {

    override fun createUser(email: String, password: String, listener: CreateUserListener) {
        val auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(activity){
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