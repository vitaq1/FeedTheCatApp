package by.bsuir.vshu.feedthecatapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Game(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

) {
    override fun toString(): String {
        return "Game ${id + 1}"
    }
}

