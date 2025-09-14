package com.example.siprofil

import android.app.Activity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.siprofil.databinding.ActivityTampilDataBinding

class TampilData : AppCompatActivity() {

    private  lateinit var binding: ActivityTampilDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityTampilDataBinding.inflate(layoutInflater)

        setContentView(binding.root)

        var nama = intent.getStringExtra(MainActivity.EXTRA_NAMA)
        var nim = intent.getStringExtra(MainActivity.EXTRA_NIM)
        var hobi = intent.getStringExtra(MainActivity.EXTRA_HOBI)
        var quote = intent.getStringExtra(MainActivity.EXTRA_QUOTE)

        with(binding){
            dtlNama.text = "${nama}"
            dtlNim.text = "${nim}"
            dtlHobi.text = "${hobi}"
            dtlQuote.text = "${quote}"

            btnKembali.setOnClickListener {
                finish()
            }
        }

    }
}