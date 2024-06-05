package com.l0122012.alfathroziq.profilpribadi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_NIM = "extra_nim"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_BATCH = "extra_batch"
        const val EXTRA_PRODI = "extra_prodi"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tvProfileData : TextView = findViewById(R.id.tv_profile_data)
        val nim = intent.getStringExtra(EXTRA_NIM)
        val name = intent.getStringExtra(EXTRA_NAME)
        val batch = intent.getIntExtra(EXTRA_BATCH, 0)
        val isProdi = intent.getStringExtra(EXTRA_PRODI)

        val text = """
            $nim
            
            $name
            
            $batch
            
            $isProdi
        """.trimIndent()

        tvProfileData.text = text

        val btnShare : Button = findViewById(R.id.buttonshare)
        btnShare.setOnClickListener(this)

        val btnLinkedin : Button = findViewById(R.id.buttonlinkedin)
        btnLinkedin.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.buttonshare -> {
                val intent = Intent(Intent.ACTION_SEND)
                intent.setType("text/plain")
                intent.putExtra(Intent.EXTRA_SUBJECT,"Profil Pribadi")
                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("alfathroziq94@gmail.com"))
                intent.putExtra(Intent.EXTRA_TEXT, """Halo, Perkenalkan.
Nama        : Alfath Roziq Widhayaka.
NIM         : L0122012
Jurusan     : INFORMATIKA
Angkatan    : 2022.

Aku suka coding setiap hari di kamarku dengan ngabisin waktu rata-rata 3 jam perhari buat ngoding. Bahasa yang aku sukai itu bahasa Kotlin.""")
                startActivity(Intent.createChooser(intent, "Share via..."))
            }
            R.id.buttonlinkedin -> {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://www.linkedin.com/in/alfath-roziq-widhayaka-69237a226/")
                startActivity(intent)
            }
        }
    }
}