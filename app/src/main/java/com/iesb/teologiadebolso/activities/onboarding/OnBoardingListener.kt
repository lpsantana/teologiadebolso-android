package com.iesb.teologiadebolso.activities.onboarding

import android.content.Context
import com.iesb.teologiadebolso.model.Board

interface OnBoardingListener{
    interface Model {
        fun getBoardByIndex(index: Int): Board
        fun salvar(context: Context)
    }

    interface View {
        fun printIconPage(index: Int, shape: Int)
        fun printTitulo(titulo: String)
        fun printDescricao(descricao: String)
        fun printImage(img: Int)
        fun printIcon(img: Int)
        fun animacao()
        fun mudarParaInvisivel()
        fun nextView()
        fun getContext(): Context
    }

    interface Presenter {
        fun changeBoarding(direction: Int)
        fun initOnBoarding()
        fun pular()
    }
}