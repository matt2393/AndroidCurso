package dev.matt2393.claseandroid1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import dev.matt2393.claseandroid1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //private var button: Button? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.buttonMain.setOnClickListener {
            Toast.makeText(this, "Button", Toast.LENGTH_SHORT).show()
        }
        binding.imageMain.setOnClickListener {
            Toast.makeText(this, "Imagen", Toast.LENGTH_SHORT).show()
            binding.buttonMain.text = "Algo"
        }
        binding.textNombreMain.setOnClickListener {
            Toast.makeText(this, "Texto", Toast.LENGTH_SHORT).show()

        }

        binding.buttonMain.setOnLongClickListener {
            Toast.makeText(this, "Button Largo", Toast.LENGTH_SHORT).show()
            true
        }
    }

    override fun onStart() {
        super.onStart()
    }
}