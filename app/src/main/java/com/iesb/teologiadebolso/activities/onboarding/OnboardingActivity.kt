package com.iesb.teologiadebolso.activities.onboarding

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
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
    }

    override fun printTitulo(titulo: String) {
        txt_titulo.text = titulo
    }

    override fun printDescricao(descricao: String) {
        txt_descricao.text = descricao
    }

    override fun printImage(img: Int) {
        img_imagem.setBackgroundResource(img)
    }

    override fun printIcon(img: Int) {
        img_icone.setBackgroundResource(img)
    }

    override fun animacao() {
        val animacao = getAnimacao(0.1f, 1f, 1000)
        animacao.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {
            }

            override fun onAnimationStart(p0: Animation?) {
                Handler().postDelayed({
                    val animation = getAnimacao(0f, 1f, 800)
                    animation.setAnimationListener(object : Animation.AnimationListener {
                        override fun onAnimationRepeat(p0: Animation?) {
                        }

                        override fun onAnimationEnd(p0: Animation?) {
                        }

                        override fun onAnimationStart(p0: Animation?) {
                            Handler().postDelayed({
                                val animation = getAnimacao(0f, 1f, 900)
                                txt_titulo.visibility = View.VISIBLE
                                txt_titulo.startAnimation(animation)
                                animation.start()

                                val animacao = getAnimacao(0f, 1f, 1500)
                                txt_descricao.visibility = View.VISIBLE
                                txt_descricao.startAnimation(animacao)
                                animacao.start()
                            }, 300)
                        }

                    })
                    img_icone.visibility = View.VISIBLE
                    img_icone.startAnimation(animation)
                    animation.start()
                }, 300)
            }

            override fun onAnimationEnd(p0: Animation?) {
            }
        })
        img_imagem.visibility = View.VISIBLE
        img_imagem.startAnimation(animacao)
        animacao.start()
    }

    override fun mudarParaInvisivel() {
        img_imagem.visibility = View.INVISIBLE
        img_icone.visibility = View.INVISIBLE
        txt_titulo.visibility = View.INVISIBLE
        txt_descricao.visibility = View.INVISIBLE
    }

    private fun getAnimacao(start: Float, end: Float, time: Long): Animation{
        val animation = AlphaAnimation(start, end)
        animation.duration = time
        return animation
    }

}
