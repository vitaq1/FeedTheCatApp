package by.bsuir.vshu.feedthecatapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Result(
    @PrimaryKey(autoGenerate = true)
    val resultId: Int = 0,
    var gameId: Int,
    val date: String,
    var count: Int
)