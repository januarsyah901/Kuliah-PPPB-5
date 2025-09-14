package com.example.siprofil

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.siprofil.databinding.ActivityEditDataBinding

class EditData : AppCompatActivity() {

    private lateinit var binding: ActivityEditDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityEditDataBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val nama = intent.getStringExtra(MainActivity.EXTRA_NAMA)
        val nim = intent.getStringExtra(MainActivity.EXTRA_NIM)
        val hobi = intent.getStringExtra(MainActivity.EXTRA_HOBI)
        val quote = intent.getStringExtra(MainActivity.EXTRA_QUOTE)

        with(binding){

            txtEdtNama.setText(nama)
            txtEdtNim.setText(nim)
            txtEdtHobi.setText(hobi)
            txtEdtQuote.setText(quote)

            btnSimpan.setOnClickListener {
                val resultIntent = Intent()

                resultIntent.putExtra(MainActivity.EXTRA_NAMA, txtEdtNama.text.toString())
                resultIntent.putExtra(MainActivity.EXTRA_NIM, txtEdtNim.text.toString())
                resultIntent.putExtra(MainActivity.EXTRA_HOBI, txtEdtHobi.text.toString())
                resultIntent.putExtra(MainActivity.EXTRA_QUOTE, txtEdtQuote.text.toString())
                setResult(RESULT_OK, resultIntent)
                finish()
            }

            btnBatal.setOnClickListener {
                finish()
            }

        }

    }
}