package by.bsuir.vshu.feedthecatapp.ui.login

import by.bsuir.vshu.feedthecatapp.domain.model.Game

interface LoginContract {

    interface LoginView {

        fun createNewGameAction()

        fun playChosenGameAction()

        fun deleteChosenGameAction()

        fun openPlayWindowWithGame()

        fun setGamesToSpinner(games: List<Game>)

        fun getSelectedGame(): Game

    }

    interface LoginPresenter{

        fun init()

        fun onCreateNewGame()

        fun onPlayChosenGame()

        fun loadGames()

        fun onDeleteChosenGame()

    }

}