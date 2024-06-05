package com.l0122012.alfathroziq.responsi1pab.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.l0122012.alfathroziq.responsi1pab.R
import com.l0122012.alfathroziq.responsi1pab.databinding.FragmentHomeBinding

@Suppress("NAME_SHADOWING")
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    companion object {
        const val EXTRA_IMAGE = "extra_image"
        const val EXTRA_HEADER = "extra_header"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRektorat.setOnClickListener { view ->
            val mBundle = Bundle()
            mBundle.putString(EXTRA_IMAGE, "rektor")
            mBundle.putString(EXTRA_HEADER, "Rektor UNS")
            mBundle.putString(EXTRA_NAME, "Dr. Chatarina Muliana, S.H., S.E., M.H. Plt. Rektor")
            mBundle.putString(EXTRA_DESCRIPTION, "Dr. Chatarina Muliana, S.H., S.E., M.H. adalah Pelaksana Tugas (Plt.) Rektor Universitas Sebelas Maret (UNS) Surakarta pada 7 Maret 2024. Chatarina menggantikan Prof. Dr. Jamal Wiwoho, S.H., M.Hum. yang mengundurkan diri dari jabatannya sebagai Rektor UNS pada 19 Januari 2024.")
            view.findNavController().navigate(R.id.action_navigation_home_to_rektorFragment2, mBundle)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}