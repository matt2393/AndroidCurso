package dev.matt2393.claseandroid.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.matt2393.claseandroid.R
import dev.matt2393.claseandroid.login.LoginActivity
import java.util.*

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val timer = Timer()
        val timerTask = object: TimerTask() {
            override fun run() {
                runOnUiThread {
                    startActivity(
                        Intent(this@SplashScreenActivity, LoginActivity::class.java)
                    )
                    finish()
                }
            }

        }
        timer.schedule(timerTask, 3500)

    }
}