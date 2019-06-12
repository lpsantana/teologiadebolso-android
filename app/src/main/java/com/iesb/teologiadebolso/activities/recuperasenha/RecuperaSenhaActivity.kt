package com.iesb.teologiadebolso.activities.recuperasenha

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.iesb.teologiadebolso.R
import com.iesb.teologiadebolso.util.DialogUtil
import kotlinx.android.synthetic.main.activity_cadastra.*
import kotlinx.android.synthetic.main.activity_recupera_senha.*

class RecuperaSenhaActivity : AppCompatActivity(), RecuperaSenhaListener.View {
    private lateinit var presenter: RecuperaSenhaPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recupera_senha)

        presenter = RecuperaSenhaPresenter(this)
        presenter.initContent()
//        button_recuperar.setOnClickListener(this)
    }

    override fun getContext(): Context {
        return this
    }

    override fun showProgressAdd(isAdding: Boolean) {
        if (isAdding){
            progress_add.visibility = View.VISIBLE
        }else{
            progress_add.visibility = View.GONE
        }
    }

    override fun showAlert(title: String, message: String) {
        DialogUtil.MsgDialogOK(getContext(), title, message)
    }
}
