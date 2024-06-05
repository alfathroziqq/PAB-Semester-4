package response

import com.google.gson.annotations.SerializedName

data class UserResponse (
    @field:SerializedName("thumbnail")
    val thumbnail: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("short_description")
    val shortDescription: String,

    @field:SerializedName("platform")
    val platform: String,

    @field:SerializedName("publisher")
    val publisher: String,
)