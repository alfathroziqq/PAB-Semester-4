package com.l0122012.alfathroziq.pabweek5

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var rvCar: RecyclerView
    private val list = ArrayList<Mobil>()
    private lateinit var btnEurope: Button
    private lateinit var btnJapan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvCar = findViewById(R.id.main_Logo)
        rvCar.setHasFixedSize(true)

        btnEurope = findViewById(R.id.btn_europe)
        btnEurope.setOnClickListener(this)
        btnJapan = findViewById(R.id.btn_japan)
        btnJapan.setOnClickListener(this)

        list.addAll(getListCar())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListCar() : ArrayList<Mobil> {
        val dataName = resources.getStringArray(R.array.dataMobilEurope)
        val dataDesc = resources.getStringArray(R.array.dataDescEurope)
        val dataImg = resources.obtainTypedArray(R.array.dataImageEurope)
        val listHero = ArrayList<Mobil>()
        for (i in dataName.indices) {
            val hero = Mobil(dataName[i], dataDesc[i], dataImg.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero
    }

    @SuppressLint("Recycle")
    private fun getListCarJapan() : ArrayList<Mobil> {
        val dataName = resources.getStringArray(R.array.dataMobilJapan)
        val dataDesc = resources.getStringArray(R.array.dataDescJapan)
        val dataImg = resources.obtainTypedArray(R.array.dataImageJapan)
        val listHero = ArrayList<Mobil>()
        for (i in dataName.indices) {
            val hero = Mobil(dataName[i], dataDesc[i], dataImg.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvCar.layoutManager = LinearLayoutManager(this)
        val listMobilAdapter = ListMobilAdapter(this@MainActivity, list)
        rvCar.adapter = listMobilAdapter

        listMobilAdapter.setOnItemClickCallback(object : ListMobilAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Mobil) {
                showSelectedCar(data)
            }

        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_japan -> {
                list.clear()
                list.addAll(getListCarJapan())
                showRecyclerList()
            }

            R.id.btn_europe -> {
                list.clear()
                list.addAll(getListCar())
                showRecyclerList()
            }
        }
    }

    private fun showSelectedCar(mobil: Mobil) {
        Toast.makeText(this, mobil.name + " is selected", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvCar.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvCar.layoutManager = GridLayoutManager(this, 2)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}