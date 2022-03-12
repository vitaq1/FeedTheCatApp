package by.bsuir.vshu.feedthecatapp.ui.login

import by.bsuir.vshu.feedthecatapp.domain.model.Game
import by.bsuir.vshu.feedthecatapp.domain.repository.GameRepository

class LoginPresenter : LoginContract.LoginPresenter {

    private var view: LoginContract.LoginView
    private var gameRepository: GameRepository

    constructor(view: LoginContract.LoginView) {
        this.view = view
        gameRepository = GameRepository
    }

    override fun init() {
        loadGames()
    }


    override fun onCreateNewGame() {
        val game = Game()
        gameRepository.addGame(game)
        gameRepository.setSelectedGame(gameRepository.getAllGames().last())
        view.openPlayWindowWithGame()
    }
    override fun onPlayChosenGame() {
        gameRepository.setSelectedGame(view.getSelectedGame())
        view.openPlayWindowWithGame()
    }

    override fun loadGames() {
        val games: List<Game> = gameRepository.getAllGames()
        view.setGamesToSpinner(games)
    }

    override fun onDeleteChosenGame() {
        gameRepository.deleteGame(view.getSelectedGame())
        loadGames()
    }


}