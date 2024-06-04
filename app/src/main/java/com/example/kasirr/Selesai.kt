package com.example.kasirr

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class Selesai : AppCompatActivity() {

    private lateinit var btnMenu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selesai)

        // Mendapatkan tanggal dan waktu hari ini
        val dateNow = Date()

        // Format tanggal dan waktu sesuai kebutuhan
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
        val dateAndTime: String = dateFormat.format(dateNow)

        // Menampilkan tanggal dan waktu pada TextView
        val textView: TextView = findViewById(R.id.waktu)
        textView.text = dateAndTime

        // Dapatkan data pesanan dari Intent
        val pesananTextView: TextView = findViewById(R.id.tv_pesanan)
        val intentPesanan = intent
        if (intentPesanan.hasExtra("pesanan")) {
            val pesanan = intentPesanan.getStringExtra("pesanan")
            pesananTextView.text = pesanan
        } else {
            pesananTextView.text = "Tidak ada data pesanan."
        }

        btnMenu = findViewById(R.id.btn_menu)
        btnMenu.setOnClickListener {
            val intent = Intent(this@Selesai, Pesan::class.java)
            startActivity(intent)
        }
    }
}
