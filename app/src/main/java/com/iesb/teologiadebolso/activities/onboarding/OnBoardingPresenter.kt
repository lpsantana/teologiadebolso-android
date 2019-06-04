package com.iesb.teologiadebolso.activities.onboarding

import com.iesb.teologiadebolso.R
import kotlinx.android.synthetic.main.activity_onboarding.*

class OnBoardingPresenter(private val view: OnBoardingListener.View,
                          private val model: OnBoardingModel = OnBoardingModel(),
                          private var step: Int = 0
) : OnBoardingListener.Presenter {

    public val RIGHT = 0
    public val LEFT = 1

    override fun initOnBoarding() {
        val board = model.getBoardByIndex(step)
        view.printImage(board.img)
        view.printIcon(board.imgicon)
        view.printTitulo(board.titulo)
        view.printDescricao(board.descricao)
    }

    override fun changeBoarding(direction: Int) {
        changeIconPage(direction)
        val board = model.getBoardByIndex(step)
        view.mudarParaInvisivel()
        view.printTitulo(board.titulo)
        view.printDescricao(board.descricao)
        view.printIcon(board.imgicon)
        view.printImage(board.img)
        view.animacao()
    }

    private fun changeIconPage(direction: Int) {
        var last = 0
        var next = 0
        when (direction) {
            RIGHT -> {
                if (step == 4) {
                    step = 0
                    last = 4
                    next = 0
                } else {
                    last = step
                    step++
                    next = step
                }
            }
            LEFT -> {
                if (step == 0) {
                    step = 4
                    last = 0
                    next = step
                } else {
                    last = step
                    step--
                    next = step
                }
            }
        }
        view.printIconPage(last, R.drawable.onboarding_pager_circle_icon)
        view.printIconPage(next, R.drawable.onboarding_pager_round_icon)
    }

}