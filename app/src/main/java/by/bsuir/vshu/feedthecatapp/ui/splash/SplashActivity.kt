package by.bsuir.vshu.feedthecatapp.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import by.bsuir.vshu.feedthecatapp.R
import by.bsuir.vshu.feedthecatapp.ui.login.LoginActivity
import by.bsuir.vshu.feedthecatapp.domain.AppDatabase

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        this.supportActionBar?.hide()

        AppDatabase.getDatabase(this)


        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 1000)
    }

}