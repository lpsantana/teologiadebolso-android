package com.iesb.teologiadebolso.listener

interface FirebaseListener {
    fun onSuccess(email: String)
    fun onFail()
}