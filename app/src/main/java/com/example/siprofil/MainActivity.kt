package com.example.siprofil

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.siprofil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object{
        const val EXTRA_NAMA = "extra_nama"
        const val EXTRA_NIM = "extra_nim"
        const val EXTRA_HOBI = "extra_hobi"
        const val EXTRA_QUOTE = "extra_quote"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        with(binding){
            btnToData.setOnClickListener {
                val intentToData = Intent(this@MainActivity, Data::class.java)
                intentToData.putExtra(MainActivity.EXTRA_NAMA, "Akmal Manggala Putra")
                intentToData.putExtra(MainActivity.EXTRA_NIM, "24/536182/SV/24402")
                startActivity(intentToData)

            }
        }
    }
}