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

class SaranaFragment : Fragment() {
    private var list = ArrayList<Sarana>()
    private lateinit var rvSarana: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_sarana, container, false)
        rvSarana = root.findViewById(R.id.rv_sarana)
        rvSarana.setHasFixedSize(true)

        list = getListSarana()

        showRecyclerList(rvSarana)

        return root
    }

    @SuppressLint("Recycle")
    private fun getListSarana() : ArrayList<Sarana> {
        val dataName = resources.getStringArray(R.array.data_name_sarana)
        val dataImg = resources.obtainTypedArray(R.array.data_img_sarana)
        val listHero = ArrayList<Sarana>()
        for (i in dataName.indices) {
            val hero = Sarana(dataName[i], "", dataImg.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList(rvSarana: RecyclerView) {
        val gridLayoutManager = GridLayoutManager(requireContext(), 2)
        rvSarana.layoutManager = gridLayoutManager
        val listSaranaAdapter = ListSaranaAdapter(list)
        rvSarana.adapter = listSaranaAdapter
    }
}