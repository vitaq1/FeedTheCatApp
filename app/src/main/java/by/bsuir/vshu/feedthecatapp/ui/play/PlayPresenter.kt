package by.bsuir.vshu.feedthecatapp.ui.play

import by.bsuir.vshu.feedthecatapp.domain.repository.GameRepository

class PlayPresenter : PlayContract.PlayPresenter {

    private var view: PlayContract.PlayView
    private var repository: GameRepository

    var taps = 0

    constructor(view: PlayContract.PlayView) {
        this.view = view
        repository = GameRepository
    }

    override fun init() {
        taps = repository.getTotalTaps(repository.getSelectedGame().id)
        view.setTaps(taps.toString())
    }

    override fun onFeedButtonPressed() {
        view.setTaps((++taps).toString())
        repository.incResultTaps()
        if (taps % 15 == 0) view.playCatAnimation()
    }

    override fun onShareButtonPressed() {
        view.showShareActivity("I got $taps taps!")
    }

    override fun onInfoButtonPressed() {
        view.showInfoDialogFragment()
    }

    override fun onHelpButtonPressed() {
        view.showHelpActivity()
    }


}