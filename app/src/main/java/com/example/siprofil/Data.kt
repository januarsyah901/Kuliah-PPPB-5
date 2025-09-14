package com.example.siprofil

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.siprofil.databinding.ActivityDataBinding

class Data : AppCompatActivity() {

    private lateinit var binding: ActivityDataBinding
    private var nama: String? = null
    private var nim: String? = null
    private var hobi: String? = "Menggambar" // default
    private var quote: String? = "Pengalaman Adalah Guru Terbaik" // default

    private var launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if (result.resultCode == Activity.RESULT_OK){
            val data = result.data
            nama = data?.getStringExtra(MainActivity.EXTRA_NAMA)
            nim = data?.getStringExtra(MainActivity.EXTRA_NIM)
            hobi = data?.getStringExtra(MainActivity.EXTRA_HOBI)
            quote = data?.getStringExtra(MainActivity.EXTRA_QUOTE)

            binding.txtNama.text = nama
            binding.txtNim.text = nim

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDataBinding.inflate(layoutInflater)

        setContentView(binding.root)

        nama = intent.getStringExtra(MainActivity.EXTRA_NAMA)
        nim = intent.getStringExtra(MainActivity.EXTRA_NIM)

        with(binding){
            txtNama.text = nama
            txtNim.text = nim

            btnToDetail.setOnClickListener {
                val intentToDetail = Intent(this@Data, TampilData::class.java)
                intentToDetail.putExtra(MainActivity.EXTRA_NAMA, nama)
                intentToDetail.putExtra(MainActivity.EXTRA_NIM, nim)
                intentToDetail.putExtra(MainActivity.EXTRA_HOBI, hobi)
                intentToDetail.putExtra(MainActivity.EXTRA_QUOTE, quote)
                startActivity(intentToDetail)
            }

            btnToEdit.setOnClickListener {
                val intentToEdit = Intent(this@Data, EditData::class.java)
                intentToEdit.putExtra(MainActivity.EXTRA_NAMA, nama)
                intentToEdit.putExtra(MainActivity.EXTRA_NIM, nim)
                intentToEdit.putExtra(MainActivity.EXTRA_HOBI, hobi)
                intentToEdit.putExtra(MainActivity.EXTRA_QUOTE, quote)
                launcher.launch(intentToEdit)
            }

        }

    }
}