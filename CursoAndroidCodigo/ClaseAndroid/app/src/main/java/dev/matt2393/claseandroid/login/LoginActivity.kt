package dev.matt2393.claseandroid.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.matt2393.claseandroid.R
import dev.matt2393.claseandroid.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerLogin, LoginFragment())
            .commit()
    }
}