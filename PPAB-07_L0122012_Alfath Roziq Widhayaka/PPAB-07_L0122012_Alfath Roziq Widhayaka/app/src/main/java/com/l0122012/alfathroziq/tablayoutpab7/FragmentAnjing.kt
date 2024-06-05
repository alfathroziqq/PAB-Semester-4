package com.l0122012.alfathroziq.tablayoutpab7

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentAnjing : Fragment() {
    private var list = ArrayList<Dog>()
    private lateinit var rvDogs: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_anjing, container, false)
        rvDogs = root.findViewById(R.id.rv_dog)
        rvDogs.setHasFixedSize(true)

        list = getListDogs()

        showRecyclerList(rvDogs)

        return root
    }

    @SuppressLint("Recycle")
    private fun getListDogs() : ArrayList<Dog> {
        val dataName = resources.getStringArray(R.array.data_anjing)
        val dataDesc = resources.getStringArray(R.array.desc_anjing)
        val dataImg = resources.obtainTypedArray(R.array.img_anjing)
        val listHero = ArrayList<Dog>()
        for (i in dataName.indices) {
            val hero = Dog(dataName[i], dataDesc[i], dataImg.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList(rvDogs: RecyclerView) {
        rvDogs.layoutManager = LinearLayoutManager(requireContext())
        val listDogAdapter = ListDogAdapter(list)
        rvDogs.adapter = listDogAdapter
    }
}