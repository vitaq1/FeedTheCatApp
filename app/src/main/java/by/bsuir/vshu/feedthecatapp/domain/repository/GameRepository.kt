package by.bsuir.vshu.feedthecatapp.domain.repository

import by.bsuir.vshu.feedthecatapp.domain.AppDatabase
import by.bsuir.vshu.feedthecatapp.domain.dao.GameDao
import by.bsuir.vshu.feedthecatapp.domain.model.Achievement
import by.bsuir.vshu.feedthecatapp.domain.model.Game
import by.bsuir.vshu.feedthecatapp.domain.model.Result
import java.text.SimpleDateFormat
import java.util.*


object GameRepository {


    var gameDao: GameDao = AppDatabase.getDatabase().gameDao()
    private lateinit var selectedGame: Game
    private var currentResult: Result? = null
    private lateinit var achievements: List<Achievement>

    fun getSelectedGame(): Game {
        return selectedGame
    }

    fun setSelectedGame(game: Game) {
        selectedGame = game
    }

    fun getCurrentResult(): Result {
        if (currentResult == null){
            currentResult = Result(0, selectedGame.id,
                SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.US).format(Calendar.getInstance().time).toString(),0)
        }
        return currentResult!!
    }

    fun incResultTaps() {
        currentResult!!.count++
    }

    fun getAllGames(): List<Game> {
        return gameDao.getAllGames()
    }

    fun addGame(game: Game) {
        gameDao.insert(game)
    }

    fun deleteGame(game: Game) {
        gameDao.delete(game)
    }

    fun getResults(id: Int): List<Result> {
        return gameDao.getResultList(id)
    }

    fun getTotalTaps(id: Int): Int{
        var taps = 0
        var results = getResults(id)
        for (res in results) taps += res.count
        taps += getCurrentResult().count
        return taps
    }

    fun addResult(result: Result) {
        gameDao.insertResult(result)
    }

    fun getAchievements(): List<Achievement>{
        return achievements
    }

    fun setAchievements(achievements: List<Achievement>){
        GameRepository.achievements = achievements
    }

    fun addAchievement(achievement: Achievement){
        achievements.plus(achievement)
    }

}