package by.bsuir.vshu.feedthecatapp.domain

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import by.bsuir.vshu.feedthecatapp.domain.dao.GameDao
import by.bsuir.vshu.feedthecatapp.domain.model.Game
import by.bsuir.vshu.feedthecatapp.domain.model.Result


@Database(entities = [Game::class, Result::class], version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context? = null): AppDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context!!, AppDatabase::class.java, "appDatabase").allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build()
                }
            }
            return INSTANCE!!
        }
    }
}