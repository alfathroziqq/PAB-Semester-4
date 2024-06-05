package com.l0122012.alfathroziq.bottomnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.l0122012.alfathroziq.bottomnavigation.databinding.FragmentNextHomeBinding

@Suppress("NAME_SHADOWING")
class NextHomeFrag : Fragment() {

    private var _binding: FragmentNextHomeBinding? = null
    private val binding get() = _binding!!
    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_SINGER = "extra_singer"
        const val EXTRA_DURATION = "extra_duration"
        const val EXTRA_DESCRIPTION = "extra_description"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNextHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDetailFragment1.setOnClickListener { view ->
            val mBundle = Bundle()
            mBundle.putString(EXTRA_NAME, "we can't be friends")
            mBundle.putString(EXTRA_SINGER, "Ariana Grande")
            mBundle.putString(EXTRA_DURATION, "3:49")
            mBundle.putString(EXTRA_DESCRIPTION, "With her four-octave vocal acrobatics and iconic image, American singer, songwriter, and actress Ariana Grande has solidified her place as one of the quintessential pop stars of her generation, racking up stacks of awards and chart records in the process. Emerging in the early 2010s with the hit single \"The Way,\" Grande was primed to follow in the footsteps of her biggest influences, Whitney Houston and Mariah Carey, due in part to her powerhouse vocals. With its Babyface production, her debut, Yours Truly, underscored her debt to '90s R&B, but Grande quickly incorporated hip-hop and EDM into her sound.")
            view.findNavController().navigate(R.id.action_nextHomeFrag_to_detailCategoryFragment, mBundle)
        }

        binding.btnDetailFragment2.setOnClickListener { view ->
            val mBundle = Bundle()
            mBundle.putString(EXTRA_NAME, "Kuingin Pisah")
            mBundle.putString(EXTRA_SINGER, "Nabila Taqiyyah")
            mBundle.putString(EXTRA_DURATION, "3:55")
            mBundle.putString(EXTRA_DESCRIPTION, "Nabila Taqiyyah, the young and bright talent from Aceh, is the runner- up of Indonesian Idol Season 12. With only 19 years of age, she has shown her versatility and talent in singing through her songs, \"Menghargai Kata Rinļu\" and her recent hit song \"Ku Ingin Pisah.\" Her distinct voice characteristic topped with a wide vocal range make her gained a lot of fans, Thenablovers, who have been supporting her since the Indonesian Idol days.")
            view.findNavController().navigate(R.id.action_nextHomeFrag_to_detailCategoryFragment, mBundle)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}