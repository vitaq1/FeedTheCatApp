package by.bsuir.vshu.feedthecatapp.domain.dao

import androidx.room.*
import by.bsuir.vshu.feedthecatapp.domain.model.Game
import by.bsuir.vshu.feedthecatapp.domain.model.Result


@Dao
abstract class GameDao {

    @Query("SELECT * FROM game")
    abstract fun getAllGames(): List<Game>

    @Query("SELECT * FROM game WHERE id = :id")
    abstract fun getGameById(id: Int): Game

    @Query("DELETE FROM game WHERE id = :id")
    abstract fun deleteGameById(id: Long)

    @Query("SELECT * FROM result WHERE gameId = :id ORDER BY gameId ASC")
    abstract fun getResultList(id: Int): List<Result>

    @Insert
    abstract fun insertResultList(results: List<Result?>?)

    @Insert
    abstract fun insertResult(result: Result)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(game: Game?)

    @Update
    abstract fun update(game: Game?)

    @Delete
    abstract fun delete(game: Game?)




}