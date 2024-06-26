package com.l0122012.alfathroziq.profilpribadi

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnProfile : Button = findViewById(R.id.btn_profile)
        btnProfile.setOnClickListener(this)

        val btnGithub : Button = findViewById(R.id.button2)
        btnGithub.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btn_profile -> {
                val profileIntent = Intent(this@MainActivity, ProfileActivity::class.java)
                profileIntent.putExtra(ProfileActivity.EXTRA_NIM, "L0122012")
                profileIntent.putExtra(ProfileActivity.EXTRA_NAME, "Alfath Roziq Widhayaka")
                profileIntent.putExtra(ProfileActivity.EXTRA_BATCH, 2022)
                profileIntent.putExtra(ProfileActivity.EXTRA_PRODI, "Informatika")
                startActivity(profileIntent)
            }
            R.id.button2 -> {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://github.com/alfathroziqq")
                startActivity(intent)
            }
        }
    }
}