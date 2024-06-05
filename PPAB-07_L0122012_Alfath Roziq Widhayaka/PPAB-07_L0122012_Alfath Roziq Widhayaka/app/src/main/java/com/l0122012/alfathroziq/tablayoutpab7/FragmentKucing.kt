package com.l0122012.alfathroziq.tablayoutpab7

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentKucing : Fragment() {
    private var list = ArrayList<Cat>()
    private lateinit var rvCats: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_kucing, container, false)
        rvCats = root.findViewById(R.id.rv_cats)
        rvCats.setHasFixedSize(true)

        list = getListCats()

        showRecyclerList(rvCats)

        return root
    }

    @SuppressLint("Recycle")
    private fun getListCats() : ArrayList<Cat> {
        val dataName = resources.getStringArray(R.array.data_kucing)
        val dataDesc = resources.getStringArray(R.array.desc_kucing)
        val dataImg = resources.obtainTypedArray(R.array.img_kucing)
        val listHero = ArrayList<Cat>()
        for (i in dataName.indices) {
            val hero = Cat(dataName[i], dataDesc[i], dataImg.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList(rvCats: RecyclerView) {
        rvCats.layoutManager = LinearLayoutManager(requireContext())
        val listCatAdapter = ListCatAdapter(list)
        rvCats.adapter = listCatAdapter
    }
}