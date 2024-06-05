package com.l0122012.alfathroziq.bottomnavigation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.l0122012.alfathroziq.bottomnavigation.R
import com.l0122012.alfathroziq.bottomnavigation.databinding.FragmentHomeBinding

@Suppress("NAME_SHADOWING")
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

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

        binding.btnNextHome.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_navigation_home_to_nextHomeFrag)
        )
        binding.btnFavorite.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_navigation_home_to_navigation_favorite)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}