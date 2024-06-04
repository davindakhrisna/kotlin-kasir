package com.example.kasirr

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.kasirr.R

class MainActivity : AppCompatActivity() {

    private lateinit var btnMenu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMenu = findViewById(R.id.btn_menu)
        btnMenu.setOnClickListener {
            val intent = Intent(this@MainActivity, Pesan::class.java)

            // Start activity
            startActivity(intent)
        }
    }
}
