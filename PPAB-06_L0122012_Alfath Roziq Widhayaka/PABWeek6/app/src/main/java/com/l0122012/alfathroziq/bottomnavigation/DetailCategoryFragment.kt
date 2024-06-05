package com.l0122012.alfathroziq.bottomnavigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.l0122012.alfathroziq.bottomnavigation.databinding.FragmentDetailCategoryBinding

class DetailCategoryFragment : Fragment() {

    private var _binding: FragmentDetailCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDetailCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataName = arguments?.getString(NextHomeFrag.EXTRA_NAME)
        val dataSinger = arguments?.getString(NextHomeFrag.EXTRA_SINGER)
        val dataDuration = arguments?.getString(NextHomeFrag.EXTRA_DURATION)
        val dataDescription = arguments?.getString(NextHomeFrag.EXTRA_DESCRIPTION)

        binding.tvCategoryName.text = dataName
        binding.tvCategorySinger.text = dataSinger
        binding.tvCategoryDuration.text = "Duration : $dataDuration"
        binding.tvCategoryDescription.text = dataDescription
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}