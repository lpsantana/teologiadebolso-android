package com.iesb.teologiadebolso.activities.cadastro

import android.app.Activity
import android.util.Patterns
import com.iesb.teologiadebolso.R
import com.iesb.teologiadebolso.listener.FirebaseListener
import com.iesb.teologiadebolso.util.Validator

class CadastraPresenter(private val view: CadastraListener.View): CadastraListener.Presenter, FirebaseListener {
    private lateinit var model: CadastraListener.Model

    override fun initContent() {
        model = CadastraModel(view.getContext() as Activity)
    }

    private var isAdding = false

    override fun onAddPressed(email: String, password: String) {
        view.showProgressAdd(!isAdding)
        val isValid = Validator.validateValues(email, password)

        if (isValid){
            model.createUser(email, password, this)
        }else{
            view.showProgressAdd(false)
            val title = view.getContext().getString(R.string.warning)
            val message = view.getContext().getString(R.string.add_user_invalid_values)
            view.showAlert(title, message)
        }
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