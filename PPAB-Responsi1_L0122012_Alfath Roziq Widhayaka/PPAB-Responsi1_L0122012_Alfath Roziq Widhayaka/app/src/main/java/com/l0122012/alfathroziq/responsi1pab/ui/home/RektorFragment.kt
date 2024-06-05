package com.l0122012.alfathroziq.responsi1pab.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.l0122012.alfathroziq.responsi1pab.databinding.FragmentRektorBinding

class RektorFragment : Fragment() {

    private var _binding: FragmentRektorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRektorBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n", "DiscouragedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as? AppCompatActivity)?.supportActionBar?.title = "Detail Rektor"

        val dataHeader = arguments?.getString(HomeFragment.EXTRA_HEADER)
        val dataImage = arguments?.getString(HomeFragment.EXTRA_IMAGE)
        val dataName = arguments?.getString(HomeFragment.EXTRA_NAME)
        val dataDescription = arguments?.getString(HomeFragment.EXTRA_DESCRIPTION)

        binding.tvRektorHeader.text = dataHeader
        context?.let {
            val imageResId = it.resources.getIdentifier(dataImage, "drawable", it.packageName)
            binding.tvRektorImage.setImageResource(imageResId)
        }
        binding.tvRektorName.text = dataName
        binding.tvRektorDescription.text = dataDescription
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}