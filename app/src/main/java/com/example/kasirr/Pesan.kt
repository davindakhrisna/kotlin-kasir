package com.example.kasirr

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Pesan : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnPesan: Button

    private var mCount1 = 0
    private var mCount2 = 0
    private var mCount3 = 0
    private var mCount4 = 0
    private var mCount5 = 0
    private lateinit var mShowCount1: TextView
    private lateinit var mShowCount2: TextView
    private lateinit var mShowCount3: TextView
    private lateinit var mShowCount4: TextView
    private lateinit var mShowCount5: TextView

    // Harga menu makanan
    private val hargaCappuccino = 35000
    private val hargaSparklingTea = 30000
    private val hargaBatagor = 25000
    private val hargaCireng = 10000
    private val hargaNasiGoreng = 18000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan)

        mShowCount1 = findViewById(R.id.show_count_1)
        mShowCount2 = findViewById(R.id.show_count_2)
        mShowCount3 = findViewById(R.id.show_count_3)
        mShowCount4 = findViewById(R.id.show_count_4)
        mShowCount5 = findViewById(R.id.show_count_5)
        btnPesan = findViewById(R.id.btn_pesan)

        val btnTambah1: ImageButton = findViewById(R.id.btn_tambah1)
        val btnKurang1: ImageButton = findViewById(R.id.btn_kurang1)
        val btnTambah2: ImageButton = findViewById(R.id.btn_tambah2)
        val btnKurang2: ImageButton = findViewById(R.id.btn_kurang2)
        val btnTambah3: ImageButton = findViewById(R.id.btn_tambah3)
        val btnKurang3: ImageButton = findViewById(R.id.btn_kurang3)
        val btnTambah4: ImageButton = findViewById(R.id.btn_tambah4)
        val btnKurang4: ImageButton = findViewById(R.id.btn_kurang4)
        val btnTambah5: ImageButton = findViewById(R.id.btn_tambah5)
        val btnKurang5: ImageButton = findViewById(R.id.btn_kurang5)

        val btnAdd1: Button = findViewById(R.id.btn_add1)
        val btnAdd2: Button = findViewById(R.id.btn_add2)
        val btnAdd3: Button = findViewById(R.id.btn_add3)
        val btnAdd4: Button = findViewById(R.id.btn_add4)
        val btnAdd5: Button = findViewById(R.id.btn_add5)

        btnTambah1.setOnClickListener(this)
        btnKurang1.setOnClickListener(this)
        btnTambah2.setOnClickListener(this)
        btnKurang2.setOnClickListener(this)
        btnTambah3.setOnClickListener(this)
        btnKurang3.setOnClickListener(this)
        btnTambah4.setOnClickListener(this)
        btnKurang4.setOnClickListener(this)
        btnTambah5.setOnClickListener(this)
        btnKurang5.setOnClickListener(this)

        btnAdd1.setOnClickListener(this)
        btnAdd2.setOnClickListener(this)
        btnAdd3.setOnClickListener(this)
        btnAdd4.setOnClickListener(this)
        btnAdd5.setOnClickListener(this)

        btnPesan.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_tambah1 -> {
                mCount1++
                mShowCount1.text = mCount1.toString()
            }
            R.id.btn_kurang1 -> {
                if (mCount1 > 0) mCount1--
                mShowCount1.text = mCount1.toString()
            }
            R.id.btn_tambah2 -> {
                mCount2++
                mShowCount2.text = mCount2.toString()
            }
            R.id.btn_kurang2 -> {
                if (mCount2 > 0) mCount2--
                mShowCount2.text = mCount2.toString()
            }
            R.id.btn_tambah3 -> {
                mCount3++
                mShowCount3.text = mCount3.toString()
            }
            R.id.btn_kurang3 -> {
                if (mCount3 > 0) mCount3--
                mShowCount3.text = mCount3.toString()
            }
            R.id.btn_tambah4 -> {
                mCount4++
                mShowCount4.text = mCount4.toString()
            }
            R.id.btn_kurang4 -> {
                if (mCount4 > 0) mCount4--
                mShowCount4.text = mCount4.toString()
            }
            R.id.btn_tambah5 -> {
                mCount5++
                mShowCount5.text = mCount5.toString()
            }
            R.id.btn_kurang5 -> {
                if (mCount5 > 0) mCount5--
                mShowCount5.text = mCount5.toString()
            }

            R.id.btn_add1 -> {
                val toast = Toast.makeText(this, "$mCount1 Cappuccino Berhasil ditambahkan", Toast.LENGTH_LONG)
                toast.show()
            }
            R.id.btn_add2 -> {
                val toast = Toast.makeText(this, "$mCount2 Sparkling Tea Berhasil ditambahkan", Toast.LENGTH_LONG)
                toast.show()
            }
            R.id.btn_add3 -> {
                val toast =
                    Toast.makeText(this, "$mCount3 batagor Berhasil ditambahkan", Toast.LENGTH_LONG)
                toast.show()
            }
            R.id.btn_add4 -> {
                val toast =
                    Toast.makeText(this, "$mCount4 Cireng Berhasil ditambahkan", Toast.LENGTH_LONG)
                toast.show()
            }
            R.id.btn_add5 -> {
                val toast = Toast.makeText(this, "$mCount5 nasi goreng Berhasil ditambahkan", Toast.LENGTH_LONG)
                toast.show()
            }

            R.id.btn_pesan -> {
                val etNama: EditText = findViewById(R.id.et_nama)
                val etNomor: EditText = findViewById(R.id.et_nomor)

                val nama = etNama.text.toString()
                val nomor = etNomor.text.toString()

                if (nama.isEmpty() || nomor.isEmpty()) {
                    Toast.makeText(
                        this,
                        "Mohon lengkapi nama dan nomor meja terlebih dahulu",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val pesanan = StringBuilder()
                    pesanan.append("Pesan untuk $nama (Nomor Meja: $nomor):\n\n")

                    if (mCount1 > 0) {
                        pesanan.append("$mCount1 Cappuccino: ${mCount1 * hargaCappuccino}\n")
                    }
                    if (mCount2 > 0) {
                        pesanan.append("$mCount2 Sparkling Tea: ${mCount2 * hargaSparklingTea}\n")
                    }
                    if (mCount3 > 0) {
                        pesanan.append("$mCount3 Batagor: ${mCount3 * hargaBatagor}\n")
                    }
                    if (mCount4 > 0) {
                        pesanan.append("$mCount4 Cireng: ${mCount4 * hargaCireng}\n")
                    }
                    if (mCount5 > 0) {
                        pesanan.append("$mCount5 Nasi Goreng: ${mCount5 * hargaNasiGoreng}\n")
                    }

                    pesanan.append("\nTotal Harga: ${hitungTotalHarga()}")

                    // Menampilkan nama dan nomor meja
                    pesanan.append("\n\nNama: $nama\nNomor Meja: $nomor")

                    val intent = Intent(this@Pesan, PaymentActivity::class.java)
                    intent.putExtra("pesanan", pesanan.toString())
                    intent.putExtra("total_price", hitungTotalHarga())
                    intent.putExtra("name", nama)
                    intent.putExtra("table_number", nomor)
                    startActivity(intent)
                }
            }
        }
    }

    // Fungsi untuk menghitung total harga pesanan
    private fun hitungTotalHarga(): Int {
        return (mCount1 * hargaCappuccino) +
                (mCount2 * hargaSparklingTea) +
                (mCount3 * hargaBatagor) +
                (mCount4 * hargaCireng) +
                (mCount5 * hargaNasiGoreng)
    }
}
