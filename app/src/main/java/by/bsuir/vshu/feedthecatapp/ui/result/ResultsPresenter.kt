package by.bsuir.vshu.feedthecatapp.ui.result

import by.bsuir.vshu.feedthecatapp.domain.repository.GameRepository


class ResultsPresenter : ResultsContract.ResultsPresenter {


    private var view: ResultsContract.ResultsView
    private var repository: GameRepository

    constructor(view: ResultsContract.ResultsView) {
        this.view = view
        repository = GameRepository
    }

    override fun init() {
        view.fillTable(repository.getResults(repository.getSelectedGame().id).reversed())
    }

    override fun refreshTable() {
        TODO("Not yet implemented")
    }

}