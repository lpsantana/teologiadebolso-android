package com.iesb.teologiadebolso.activities.login

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.iesb.teologiadebolso.R
import com.iesb.teologiadebolso.activities.cadastro.CadastraActivity
import com.iesb.teologiadebolso.activities.recuperasenha.RecuperaSenhaActivity
import com.iesb.teologiadebolso.activities.tirinhas.TirinhasActivity
import com.iesb.teologiadebolso.util.DialogUtil
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginListener.View, View.OnClickListener {
    private lateinit var presenter: LoginListener.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this)
        presenter.initContent()
        button_login.setOnClickListener(this)
        action_cadastra.setOnClickListener(this)
        action_recuperar_senha.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.button_login -> {
                hideKeyboard()
                presenter.onLoginPressed(email_login.text.toString(), password_login.text.toString())
            }
            R.id.action_cadastra -> {
                goToAddUser()
            }
            R.id.action_recuperar_senha -> {
                goToResetPassword()
            }
        }
    }

    private fun hideKeyboard() {
        val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?

        if (getCurrentFocus()!!.getWindowToken() != null) {
            inputManager!!.hideSoftInputFromWindow(
                getCurrentFocus()!!.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }

    override fun getContext(): Context {
        return this
    }

    override fun showProgressLogin(isLoggin: Boolean) {
        if (isLoggin){
            progress_login.visibility = View.VISIBLE
        }else{
            progress_login.visibility = View.GONE
        }
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
