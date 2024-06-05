package com.l0122012.alfathroziq.responsi1pab.ui.facility

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.l0122012.alfathroziq.responsi1pab.R

class GedungFragment : Fragment() {
    private var list = ArrayList<Gedung>()
    private lateinit var rvGedung: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_gedung, container, false)
        rvGedung = root.findViewById(R.id.rv_gedung)
        rvGedung.setHasFixedSize(true)

        list = getListGedung()

        showRecyclerList(rvGedung)

        return root
    }

    @SuppressLint("Recycle")
    private fun getListGedung() : ArrayList<Gedung> {
        val dataName = resources.getStringArray(R.array.data_name_gedung)
        val dataImg = resources.obtainTypedArray(R.array.data_img_gedung)
        val listHero = ArrayList<Gedung>()
        for (i in dataName.indices) {
            val hero = Gedung(dataName[i], "", dataImg.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList(rvGedung: RecyclerView) {
        val gridLayoutManager = GridLayoutManager(requireContext(), 2)
        rvGedung.layoutManager = gridLayoutManager
        val listGedungAdapter = ListGedungAdapter(list)
        rvGedung.adapter = listGedungAdapter
    }
}
