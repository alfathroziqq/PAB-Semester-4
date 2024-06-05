package com.l0122012.alfathroziq.bottomnavigation.ui.favorite

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.l0122012.alfathroziq.bottomnavigation.ListMusicAdapter
import com.l0122012.alfathroziq.bottomnavigation.Music
import com.l0122012.alfathroziq.bottomnavigation.R
import com.l0122012.alfathroziq.bottomnavigation.databinding.FragmentFavoritesBinding

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoritesBinding? = null
    private lateinit var list: ArrayList<Music>

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val rvCats = root.findViewById<RecyclerView>(R.id.rvFavorite)
        rvCats.setHasFixedSize(true)

        list = getListMusic()

        showRecyclerList(rvCats)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("Recycle")
    private fun getListMusic() : ArrayList<Music> {
        val dataName = resources.getStringArray(R.array.data_music)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataImg = resources.obtainTypedArray(R.array.data_img)
        val listHero = ArrayList<Music>()
        for (i in dataName.indices) {
            val hero = Music(dataName[i], dataDesc[i], dataImg.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList(rvCats: RecyclerView) {
        rvCats.layoutManager = LinearLayoutManager(requireContext())
        val listCatAdapter = ListMusicAdapter(list)
        rvCats.adapter = listCatAdapter
    }
}