package by.bsuir.vshu.feedthecatapp.ui.achievement

import by.bsuir.vshu.feedthecatapp.domain.model.Achievement

interface AchievementContract {

    interface AchievementView {

        fun fillTable(achievements: List<Achievement>)

    }

    interface AchievementPresenter{

        fun init()

        fun createAchievements()

    }

}