package by.bsuir.vshu.feedthecatapp.ui.achievement

import by.bsuir.vshu.feedthecatapp.domain.model.Achievement
import by.bsuir.vshu.feedthecatapp.domain.repository.GameRepository

class AchievementPresenter: AchievementContract.AchievementPresenter {

    private var view: AchievementContract.AchievementView
    private var repository: GameRepository

    constructor(view: AchievementContract.AchievementView) {
        this.view = view
        repository = GameRepository
    }


    override fun init() {
        createAchievements()
        view.fillTable(repository.getAchievements())
    }

    override fun createAchievements() {

        val achievementsTemp : MutableList<Achievement> = mutableListOf()

        achievementsTemp.add(Achievement("Feed the Cat 1 time",1,false))
        achievementsTemp.add(Achievement("Feed the Cat 10 times",10,false))
        achievementsTemp.add(Achievement("Feed the Cat 50 times",50,false))
        achievementsTemp.add(Achievement("Feed the Cat 100 times",100,false))
        achievementsTemp.add(Achievement("Feed the Cat 200 times",200,false))
        achievementsTemp.add(Achievement("Feed the Cat 500 times",500,false))
        achievementsTemp.add(Achievement("Feed the Cat 1000 times",1000,false))
        achievementsTemp.add(Achievement("Feed the Cat 2000 times",2000,false))
        achievementsTemp.add(Achievement("Feed the Cat 5000 times",5000,false))

        for (item in achievementsTemp){
            if (repository.getTotalTaps(repository.getSelectedGame().id) >= item.goal ){
                item.passed = true
            }
        }

        repository.setAchievements(achievementsTemp)

    }

}