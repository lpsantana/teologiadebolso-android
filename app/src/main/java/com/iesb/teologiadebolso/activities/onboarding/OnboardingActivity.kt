package com.iesb.teologiadebolso.activities.onboarding

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.ImageView
import com.iesb.teologiadebolso.R
import kotlinx.android.synthetic.main.activity_onboarding.*

class OnboardingActivity : AppCompatActivity(), OnBoardingListener.View,View.OnClickListener {
    private lateinit var listIcons: ArrayList<ImageView>
    private lateinit var presenter: OnBoardingPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        presenter = OnBoardingPresenter(this)
        presenter.initOnBoarding()

        listIcons = arrayListOf(icones_1, icones_2, icones_3, icones_4, icones_5)
        direita.setOnClickListener(this)
        esquerda.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.direita -> presenter.changeBoarding(presenter.RIGHT)
            R.id.esquerda -> presenter.changeBoarding(presenter.LEFT)
        }
    }

    override fun printIconPage(index: Int, shape: Int) {
        listIcons?.get(index)?.setImageResource(shape)
        val animation = getAnimacao(0f, 1f, 1000)
        img_icone.startAnimation(animation)
        animation.start()
    }

    override fun printTitulo(titulo: String) {
        txt_titulo.text = titulo
        val animation = getAnimacao(0f, 1f, 500)
        txt_titulo.startAnimation(animation)
        animation.start()
    }

    override fun printDescricao(descricao: String) {
        txt_descricao.text = descricao
        val animation = getAnimacao(0f, 1f, 750)
        txt_descricao.startAnimation(animation)
        animation.start()
    }

    override fun printImage(img: Int) {
        img_imagem.setBackgroundResource(img)
        val animacao = getAnimacao(0.2f, 1f, 1500)
        img_imagem.startAnimation(animacao)
        animacao.start()
    }

    override fun printIcon(img: Int) {
        img_icone.setBackgroundResource(img)
    }

    private fun getAnimacao(start: Float, end: Float, time: Long): Animation{
        val animation = AlphaAnimation(start, end)
        animation.duration = time
        return animation
    }

}
