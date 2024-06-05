package com.l0122012.alfathroziq.responsi1pab.ui.faculty

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.l0122012.alfathroziq.responsi1pab.R

class DetailFaculty : AppCompatActivity() {
    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESC = "extra_desc"
        const val EXTRA_IMG = "extra_img"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_faculty)

        supportActionBar?.title = "Detail Fakultas"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detail_faculty)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imgMenu : ImageView = findViewById(R.id.picture)
        val tvMenuName : TextView = findViewById(R.id.namePicture)
        val tvMenuDesc : TextView = findViewById(R.id.descPicture)

        val img = intent.getIntExtra(EXTRA_IMG, 0)
        val name = intent.getStringExtra(EXTRA_NAME)
        val desc = intent.getStringExtra(EXTRA_DESC)

        imgMenu.setImageResource(img)
        tvMenuName.text = name
        tvMenuDesc.text = desc
    }
}