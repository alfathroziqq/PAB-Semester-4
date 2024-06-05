package com.l0122012.alfathroziq.ppab_10_l0122012_alfathroziqwidhayaka

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.bumptech.glide.Glide
import com.l0122012.alfathroziq.ppab_10_l0122012_alfathroziqwidhayaka.databinding.ActivitySharedBinding

@Suppress("DEPRECATION")
class SharedActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mUserPreference: UserPreference
    private lateinit var binding: ActivitySharedBinding

    private var isPreferenceEmpty = false
    private lateinit var userModel: UserModel

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.data != null && result.resultCode == FormUserPreferenceActivity.RESULT_CODE) {
            val tempUserModel = result.data?.getParcelableExtra<UserModel>(FormUserPreferenceActivity.EXTRA_RESULT)
            if (tempUserModel != null) {
                userModel = tempUserModel
                populateView(userModel)
                checkForm(userModel)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = getColor(android.R.color.white)
        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
        windowInsetsController.isAppearanceLightStatusBars = true

        supportActionBar?.title = "My User Preference"

        mUserPreference = UserPreference(this)

        showExistingPreference()

        binding.btnSave.setOnClickListener(this)
    }

    private fun showExistingPreference() {
        userModel = mUserPreference.getUser()
        populateView(userModel)
        checkForm(userModel)
    }

    private fun populateView(userModel: UserModel) {
        binding.tvName.text = if (userModel.name.isNullOrEmpty()) "Tidak Ada" else userModel.name
        binding.tvAge.text = userModel.age.toString()
        binding.tvGender.text = if (userModel.isGender) "Male" else "Female"
        binding.tvEmail.text = if (userModel.email.isNullOrEmpty()) "Tidak Ada" else userModel.email
        binding.tvPhone.text = if (userModel.phoneNumber.isNullOrEmpty()) "Tidak Ada" else userModel.phoneNumber

        val profilePictureUrl = userModel.profilePictureUrl
        if (!profilePictureUrl.isNullOrEmpty()) {
            Glide.with(this)
                .load(profilePictureUrl)
                .into(binding.ivProfilePicture)
        } else {
            binding.ivProfilePicture.setImageResource(R.drawable.hacker)
        }
    }

    private fun checkForm(userModel: UserModel) {
        if (userModel.name.isNullOrEmpty()) {
            binding.btnSave.text = getString(R.string.save)
            isPreferenceEmpty = true
        } else {
            binding.btnSave.text = getString(R.string.change)
            isPreferenceEmpty = false
        }
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_save) {
            val intent = Intent(this@SharedActivity, FormUserPreferenceActivity::class.java)
            if (isPreferenceEmpty) {
                intent.putExtra(FormUserPreferenceActivity.EXTRA_TYPE_FORM, FormUserPreferenceActivity.TYPE_ADD)
            } else {
                intent.putExtra(FormUserPreferenceActivity.EXTRA_TYPE_FORM, FormUserPreferenceActivity.TYPE_EDIT)
            }
            intent.putExtra("USER", userModel)
            resultLauncher.launch(intent)
        }
    }
}