package com.iesb.teologiadebolso.activities.login

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import com.iesb.teologiadebolso.R
import com.iesb.teologiadebolso.listener.FirebaseListener
import com.iesb.teologiadebolso.util.Validator

class LoginPresenter(private val view: LoginListener.View): LoginListener.Presenter, FirebaseListener {
    private lateinit var model: LoginListener.Model
    private var isLoggin = false

    override fun initContent() {
        model = LoginModel(view.getContext() as Activity)
    }

    override fun onLoginPressed(email: String, password: String) {
        view.showProgressLogin(!isLoggin)
        val isValid = Validator.validateValues(email, password)

        if (isValid){
            model.login(email, password, this)
        }else{
            view.showProgressLogin(false)
            val title = view.getContext().getString(R.string.warning)
            val message = view.getContext().getString(R.string.login_invalid_values)
            view.showAlert(title, message)
        }
    }

    override fun onSuccess(email: String) {
        model.saveUser(email)
        view.showProgressLogin(false)
        view.goToHome()
    }

    override fun onFail() {
        view.showProgressLogin(false)
        val title = view.getContext().getString(R.string.warning)
        val message = "Não foi possível fazer  o login! Tente novamente mais tarde."
        view.showAlert(title, message)
    }

}