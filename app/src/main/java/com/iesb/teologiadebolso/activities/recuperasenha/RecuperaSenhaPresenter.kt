package com.iesb.teologiadebolso.activities.recuperasenha

import android.app.Activity
import com.iesb.teologiadebolso.activities.cadastro.CadastraListener
import com.iesb.teologiadebolso.listener.FirebaseListener


class RecuperaSenhaPresenter(private val view: RecuperaSenhaListener.View) : RecuperaSenhaListener.Presenter, FirebaseListener{
    private lateinit var model: RecuperaSenhaListener.Model

    override fun initContent() {
        model = RecuperaSenhaModel(view.getContext() as Activity)
    }

    override fun onRecuperarPressed(email: String) {


        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccess(email: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onFail() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}