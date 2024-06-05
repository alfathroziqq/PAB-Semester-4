package ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.l0122012.alfathroziq.ppab_09_l0122012_alfathroziqwidhayaka.databinding.ActivityHomeBinding
import response.UserResponse
import retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        adapter = UsersAdapter(this@HomeActivity, arrayListOf())

        binding.rvUser.adapter = adapter
        binding.rvUser.setHasFixedSize(true)
        binding.rvUser.layoutManager = LinearLayoutManager(this)

        getUsers()
    }

    private fun getUsers() {
        ApiConfig.apiService().getUsers().enqueue(object : Callback<ArrayList<UserResponse>> {
            override fun onResponse(
                call: Call<ArrayList<UserResponse>>,
                response: Response<ArrayList<UserResponse>>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    data?.let {
                        setData(it)
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<UserResponse>>, t: Throwable) {
                Log.d("Error", "" + t.stackTraceToString())
            }
        })
    }

    fun setData(data: ArrayList<UserResponse>) {
        adapter.setData(data)
    }
}