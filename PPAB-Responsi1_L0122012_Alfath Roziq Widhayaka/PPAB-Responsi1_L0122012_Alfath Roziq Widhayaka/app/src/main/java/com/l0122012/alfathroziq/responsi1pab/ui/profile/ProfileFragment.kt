package com.l0122012.alfathroziq.responsi1pab.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.l0122012.alfathroziq.responsi1pab.R
import com.l0122012.alfathroziq.responsi1pab.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root

        val profileBundle = IntentProfile().getProfileBundle()

        val name = profileBundle.getString(EXTRA_NAME)
        val nim = profileBundle.getString(EXTRA_NIM)
        val isProdi = profileBundle.getString(EXTRA_PRODI)
        val batch = profileBundle.getInt(EXTRA_BATCH, 0)
        val faculty = profileBundle.getString(EXTRA_FACULTY)
        val university = profileBundle.getString(EXTRA_UNIVERSITY)
        val email = profileBundle.getString(EXTRA_EMAIL)

        val text = """
            $name

            $nim
            
            $isProdi
            
            $batch
            
            $faculty
            
            $university
            
            $email
        """.trimIndent()

        binding.tvProfileData.text = text

        val button = view.findViewById<Button>(R.id.buttonShare)

        button.setOnClickListener {
            onClick(it)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onClick(view: View?) {
        when (view?.id) {
            R.id.buttonShare -> {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_SUBJECT, "RESPONSI 1 PAB")
                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("alfathroziq94@gmail.com"))
                intent.putExtra(
                    Intent.EXTRA_TEXT, """Halo, Perkenalkan.
Nama        : Alfath Roziq Widhayaka.
NIM         : L0122012
Jurusan     : INFORMATIKA
Angkatan    : 2022.
Fakultas    : FATISDA
UNIVERSITAS : Universitas Sebelas Maret
Email       : alfathroziq94@gmail.com"""
                )
                startActivity(Intent.createChooser(intent, "Share via..."))
            }
        }
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_NIM = "extra_nim"
        const val EXTRA_PRODI = "extra_prodi"
        const val EXTRA_BATCH = "extra_batch"
        const val EXTRA_FACULTY = "extra_faculty"
        const val EXTRA_UNIVERSITY = "extra_university"
        const val EXTRA_EMAIL = "extra_email"
    }
}
