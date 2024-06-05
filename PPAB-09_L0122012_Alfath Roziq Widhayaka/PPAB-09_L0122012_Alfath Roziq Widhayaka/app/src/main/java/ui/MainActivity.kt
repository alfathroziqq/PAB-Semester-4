package ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.l0122012.alfathroziq.ppab_09_l0122012_alfathroziqwidhayaka.databinding.ActivityMainBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.squareup.picasso.Picasso
import cz.msebera.android.httpclient.Header
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getRandomBody()
    }

    private fun getRandomBody() {
        binding.progressBar.visibility = View.VISIBLE
        val client = AsyncHttpClient()
        val url = "https://www.freetogame.com/api/games?category=shooter"
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<Header>, responseBody: ByteArray) {
                // Jika koneksi berhasil
                binding.progressBar.visibility = View.INVISIBLE
                val result = String(responseBody)
                Log.d(TAG, result)
                try {
                    val jsonArray = JSONArray(result)
                    val jsonObject = jsonArray.getJSONObject(9)
                    val thumbnail = jsonObject.getString("thumbnail")
                    val title = jsonObject.getString("title")
                    val shortDescription = jsonObject.getString("short_description")
                    Picasso.get().load(thumbnail).into(binding.tvImg)
                    binding.tvTitle.text = title
                    binding.tvDescription.text = shortDescription

                } catch (e: Exception) {
                    Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }
                binding.btnToHome.setOnClickListener {
                    startActivity(Intent(this@MainActivity, HomeActivity::class.java))
                }
            }
            override fun onFailure(statusCode: Int, headers: Array<Header>, responseBody: ByteArray, error: Throwable) {
                // Jika koneksi gagal
                binding.progressBar.visibility = View.INVISIBLE
                val errorMessage = when (statusCode) {
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error.message}"
                }
                Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
