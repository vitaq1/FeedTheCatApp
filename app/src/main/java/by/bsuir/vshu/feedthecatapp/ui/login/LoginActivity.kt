package by.bsuir.vshu.feedthecatapp.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import by.bsuir.vshu.feedthecatapp.ui.MainActivity
import by.bsuir.vshu.feedthecatapp.R
import by.bsuir.vshu.feedthecatapp.domain.model.Game


class LoginActivity : AppCompatActivity(), LoginContract.LoginView {

    private lateinit var presenter: LoginContract.LoginPresenter

    private lateinit var newGameButton: Button
    private lateinit var playGameButton: Button
    private lateinit var deleteGameButton: Button
    lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        this.supportActionBar?.hide()

        presenter = LoginPresenter(this)

        newGameButton =
            findViewById<Button>(R.id.newGameButton).apply { setOnClickListener { createNewGameAction() } }
        playGameButton =
            findViewById<Button>(R.id.playGameButton).apply { setOnClickListener { playChosenGameAction() } }
        deleteGameButton =
            findViewById<Button>(R.id.deleteGameButton).apply { setOnClickListener { deleteChosenGameAction() } }
        spinner = findViewById(R.id.spinner)



        presenter.init()
    }


    override fun createNewGameAction() {
        presenter.onCreateNewGame()
        //TODO("add game limit check")
    }

    override fun playChosenGameAction() {
        presenter.onPlayChosenGame()
    }

    override fun deleteChosenGameAction() {
        presenter.onDeleteChosenGame()
    }

    override fun openPlayWindowWithGame() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }



    override fun setGamesToSpinner(games: List<Game>) {
        val adapter: ArrayAdapter<*> = ArrayAdapter(this, android.R.layout.simple_spinner_item, games)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    override fun getSelectedGame(): Game {
        return spinner.selectedItem as Game
    }


}