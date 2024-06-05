package com.l0122012.alfathroziq.responsi1pab.ui.faculty

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.l0122012.alfathroziq.responsi1pab.R
import com.l0122012.alfathroziq.responsi1pab.databinding.FragmentFacultyBinding

class FacultyFragment : Fragment() {

    private var _binding: FragmentFacultyBinding? = null
    private lateinit var list: ArrayList<Faculty>

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFacultyBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val rvFaculty = root.findViewById<RecyclerView>(R.id.rv_faculty)
        rvFaculty.setHasFixedSize(true)

        list = getListFaculty()

        showRecyclerList(rvFaculty)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("Recycle")
    private fun getListFaculty() : ArrayList<Faculty> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataImg = resources.obtainTypedArray(R.array.data_img)
        val listHero = ArrayList<Faculty>()
        for (i in dataName.indices) {
            val hero = Faculty(dataName[i], dataDesc[i], dataImg.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList(rvFaculty: RecyclerView) {
        rvFaculty.layoutManager = LinearLayoutManager(requireContext())
        val listFacultyAdapter = ListFacultyAdapter(requireContext(), list)
        rvFaculty.adapter = listFacultyAdapter

        rvFaculty.adapter = listFacultyAdapter

        listFacultyAdapter.setOnItemClickCallback(object : ListFacultyAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Faculty) {
                showSelectedCat(data)
            }
        })
    }

    private fun showSelectedCat(cat: Faculty) {
        Toast.makeText(requireContext(), cat.name + " is selected", Toast.LENGTH_SHORT).show()
    }
}