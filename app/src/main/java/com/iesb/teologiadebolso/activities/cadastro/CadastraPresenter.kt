package com.iesb.teologiadebolso.activities.cadastro

import android.app.Activity
import android.util.Patterns
import com.iesb.teologiadebolso.R
import com.iesb.teologiadebolso.listener.CreateUserListener

class CadastraPresenter(private val view: CadastraListener.View): CadastraListener.Presenter, CreateUserListener {
    private lateinit var model: CadastraListener.Model

    override fun initContent() {
        model = CadastraModel(view.getContext() as Activity)
    }

    private val MIN_PASSWORD = 6
    private var isAdding = false

    override fun onAddPressed(email: String, password: String) {
        view.showProgressAdd(!isAdding)
        val isValid = validateValues(email, password)

        if (isValid){
            model.createUser(email, password, this)
        }else{
            view.showProgressAdd(false)
            val title = view.getContext().getString(R.string.warning)
            val message = view.getContext().getString(R.string.add_user_invalid_values)
            view.showAlert(title, message)
        }
    }

    private fun validateValues(email: String, password: String): Boolean {
        var isValid = true
        if (!validateEmail(email) || !validatePassword(password)){
            isValid = false
        }
        return isValid
    }

    private fun validatePassword(password: String): Boolean {
        return password.length >= MIN_PASSWORD
    }

    private fun validateEmail(email: String):Boolean {
        return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.toRegex().matches(email)
    }

    override fun onSuccess(email: String) {
        model.saveUser(email)
        view.showProgressAdd(false)
        view.nextView()
    }

    override fun onFail() {
        view.showProgressAdd(false)
        val title = view.getContext().getString(R.string.warning)
        val message = view.getContext().getString(R.string.add_user_retry_add)
        view.showAlert(title, message)
    }
}