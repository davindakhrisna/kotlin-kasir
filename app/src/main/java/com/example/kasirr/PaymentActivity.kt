package com.example.kasirr

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class PaymentActivity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        dbHelper = DatabaseHelper(this)

        val pesanan = intent.getStringExtra("pesanan")
        val totalPrice = intent.getIntExtra("total_price", 0)
        val name = intent.getStringExtra("name")
        val tableNumber = intent.getStringExtra("table_number")

        val tvPesanan: TextView = findViewById(R.id.tv_pesanan)
        tvPesanan.text = pesanan

        val tvTotalPrice: TextView = findViewById(R.id.tv_total_price)
        tvTotalPrice.text = "Rp $totalPrice"

        val etAmountPaid: EditText = findViewById(R.id.et_amount_paid)
        val tvChange: TextView = findViewById(R.id.tv_change)

        val btnPay: Button = findViewById(R.id.btn_pay)
        btnPay.setOnClickListener {
            val amountPaidStr = etAmountPaid.text.toString()

            if (amountPaidStr.isEmpty()) {
                Toast.makeText(this, "Masukkan jumlah uang yang dibayar", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val amountPaid = amountPaidStr.toInt()

            when {
                amountPaid < totalPrice -> {
                    Toast.makeText(this, "Uang tidak cukup", Toast.LENGTH_LONG).show()
                }
                amountPaid == totalPrice -> {
                    Toast.makeText(this, "Makanan telah dibayar", Toast.LENGTH_LONG).show()
                    saveTransaction(name, tableNumber, pesanan, totalPrice, 0)
                    navigateToStruk(name, tableNumber, pesanan, totalPrice, 0)
                }
                amountPaid > totalPrice -> {
                    val change = amountPaid - totalPrice
                    tvChange.text = "Kembalian: Rp $change"
                    tvChange.visibility = TextView.VISIBLE
                    Toast.makeText(this, "Makanan telah dibayar", Toast.LENGTH_LONG).show()
                    saveTransaction(name, tableNumber, pesanan, totalPrice, change)
                    navigateToStruk(name, tableNumber, pesanan, totalPrice, change)
                }
            }
        }
    }

    private fun saveTransaction(name: String?, tableNumber: String?, pesanan: String?, totalPrice: Int, change: Int) {
        // Mendapatkan tanggal dan waktu saat ini
        val dateNow = Date()
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
        val dateTime: String = dateFormat.format(dateNow)

        // Simpan transaksi ke database
        dbHelper.addTransaction(name ?: "", tableNumber ?: "", pesanan ?: "", totalPrice, dateTime)
    }

    private fun navigateToStruk(name: String?, tableNumber: String?, pesanan: String?, totalPrice: Int, change: Int) {
        val intent = Intent(this@PaymentActivity, StrukActivity::class.java)
        intent.putExtra("name", name)
        intent.putExtra("table_number", tableNumber)
        intent.putExtra("pesanan", pesanan)
        intent.putExtra("total_price", totalPrice)
        intent.putExtra("change", change)
        startActivity(intent)
        finish()
    }
}
