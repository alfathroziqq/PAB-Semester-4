package retrofit

import response.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/games?category=shooter")
    fun getUsers(): Call<ArrayList<UserResponse>>
}
