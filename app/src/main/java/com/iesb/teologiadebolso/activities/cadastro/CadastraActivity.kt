package com.iesb.teologiadebolso.activities.cadastro

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.iesb.teologiadebolso.R
import com.iesb.teologiadebolso.activities.tirinhas.TirinhasActivity
import com.iesb.teologiadebolso.util.DialogUtil
import kotlinx.android.synthetic.main.activity_cadastra.*

class CadastraActivity : AppCompatActivity(), CadastraListener.View, View.OnClickListener {

    private lateinit var presenter: CadastraPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastra)

        presenter = CadastraPresenter(this)
        presenter.initContent()
        button_add.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            button_add.id -> {
                presenter.onAddPressed(email_cadastro.text.toString(), password_cadastro.text.toString())
            }
        }
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

    override fun nextView() {
        startActivity(Intent(this, TirinhasActivity::class.java))
        finish()
    }

    override fun showAlert(title: String, message: String) {
        DialogUtil.MsgDialogOK(getContext(), title, message)
    }
}
