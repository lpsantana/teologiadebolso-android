package com.iesb.teologiadebolso.activities.onboarding

import android.content.Context
import com.iesb.teologiadebolso.R
import com.iesb.teologiadebolso.model.Board
import com.iesb.teologiadebolso.preference.UserPreference

class OnBoardingModel(): OnBoardingListener.Model{
    private val boards: ArrayList<Board> = boards()

    override fun getBoardByIndex(index: Int): Board {
        return boards.get(index)
    }

    private fun boards(): ArrayList<Board> {
        return arrayListOf(
            Board("Teologia Reformada", "Um arcabouço de conteúdo \nbíblico e cristocêntrico de uma " +
                    "forma simples \nna palma da sua mão", R.drawable.boar_icon_01, R.drawable.board_img_01),
            Board("Artigos Teológicos", "Diversos textos organizados em categorias \npara acesso rápido"
                , R.drawable.board_icon_02, R.drawable.board_img_02),
            Board("Indicações de materiais", "Além de uma ótima introdução em teologia \ntenha indicações " +
                    "de qualidade \npara se aprofundar mais", R.drawable.board_icon_03, R.drawable.board_img_03),
            Board("Vídeos", "Separamos para você \nvídeos dos temas que são abordados "
                , R.drawable.board_icon_04, R.drawable.board_img_04),
            Board("História da Igreja", "Linha do tempo interativa para \nacompanhar os acontecimentos " +
                    "\nhistóricos da Igreja até os dias atuais", R.drawable.board_icon_05, R.drawable.board_img_05))
    }

    override fun salvar(context: Context) {
        UserPreference(context).saveOnBoarding()
    }
}