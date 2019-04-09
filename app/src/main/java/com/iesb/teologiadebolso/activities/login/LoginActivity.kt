package com.iesb.teologiadebolso.activities.login

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.iesb.teologiadebolso.R
import com.iesb.teologiadebolso.activities.cadastro.CadastraActivity
import com.iesb.teologiadebolso.activities.recuperasenha.RecuperaSenhaActivity
import com.iesb.teologiadebolso.activities.tirinhas.TirinhasActivity
import com.iesb.teologiadebolso.util.DialogUtil

class LoginActivity : AppCompatActivity(), LoginListener.View {
    private lateinit var presenter: LoginListener.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this)
        presenter.initContent()
    }

    override fun getContext(): Context {
        return this
    }

    override fun showProgressLogin(isAdding: Boolean) {
//        if (isAdding){
//            progress_login.visibility = View.VISIBLE
//        }else{
//            progress_login.visibility = View.GONE
//        }
    }

    override fun goToHome() {
        val intent = Intent(this, TirinhasActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finish()
    }

    override fun goToAddUser() {
        startActivity(Intent(this, CadastraActivity::class.java))
    }

    override fun goToResetPassword() {
        startActivity(Intent(this, RecuperaSenhaActivity::class.java))
    }

    override fun showAlert(title: String, message: String) {
        DialogUtil.MsgDialogOK(getContext(), title, message)
    }
}
