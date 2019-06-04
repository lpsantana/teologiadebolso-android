package com.iesb.teologiadebolso.activities.onboarding

import com.iesb.teologiadebolso.model.Board

interface OnBoardingListener{
    interface Model {
        fun getBoardByIndex(index: Int): Board
    }

    interface View {
        fun printIconPage(index: Int, shape: Int)
        fun printTitulo(titulo: String)
        fun printDescricao(descricao: String)
        fun printImage(img: Int)
        fun printIcon(img: Int)
    }

    interface Presenter {
        fun changeBoarding(direction: Int)
        fun initOnBoarding()
    }
}