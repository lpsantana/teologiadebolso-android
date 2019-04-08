package com.iesb.teologiadebolso.listener

interface CreateUserListener {
    fun onSuccess(email: String)
    fun onFail()
}