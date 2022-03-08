package by.bsuir.vshu.feedthecatapp.ui.play

interface PlayContract {

    interface PlayView{

        fun setTaps(text: String)

        fun feedAction()

        fun playCatAnimation()

        fun shareAction()

        fun infoAction()

        fun helpAction()

        fun showShareActivity(s:String)

        fun showInfoDialogFragment()

        fun showHelpActivity()

    }

    interface PlayPresenter{

        fun init()

        fun onFeedButtonPressed()

        fun onShareButtonPressed()

        fun onInfoButtonPressed()

        fun onHelpButtonPressed()


    }

}