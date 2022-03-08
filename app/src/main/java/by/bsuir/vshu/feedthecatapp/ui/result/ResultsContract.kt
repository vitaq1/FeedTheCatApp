package by.bsuir.vshu.feedthecatapp.ui.result

import by.bsuir.vshu.feedthecatapp.domain.model.Result

interface ResultsContract {

    interface ResultsView{

        fun fillTable(results: List<Result>)
    }

    interface ResultsPresenter{

        fun init()

        fun refreshTable()

    }


}