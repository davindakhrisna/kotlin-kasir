package com.example.kasirr

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class StrukActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_struk)

        val name = intent.getStringExtra("name")
        val tableNumber = intent.getStringExtra("table_number")
        val pesanan = intent.getStringExtra("pesanan")
        val totalPrice = intent.getIntExtra("total_price", 0)
        val change = intent.getIntExtra("change", 0)

        findViewById<TextView>(R.id.tv_name).text = name
        findViewById<TextView>(R.id.tv_table_number).text = tableNumber
        findViewById<TextView>(R.id.tv_pesanan).text = pesanan
        findViewById<TextView>(R.id.tv_total_price).text = "Rp $totalPrice"
        findViewById<TextView>(R.id.tv_change).text = "Rp $change"

        val btnBack: Button = findViewById(R.id.btn_back)
        btnBack.setOnClickListener {
            showBackOptionsDialog()
        }
    }

    private fun showBackOptionsDialog() {
        val options = arrayOf("Kembali ke Home", "Pesan Kembali")
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Pilih Aksi")
        builder.setItems(options) { dialog, which ->
            when (which) {
                0 -> {
                    val intent = Intent(this@StrukActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                1 -> {
                    val intent = Intent(this@StrukActivity, Pesan::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
        builder.show()
    }
}
