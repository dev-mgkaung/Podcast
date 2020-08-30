package mk.podcast.com.datas.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "playlist")
data class PlayListVO(
    @PrimaryKey
    @SerializedName("id") val id: String,
    @SerializedName("description") val description: String,
    @SerializedName("episode_count")  val episode_count: Int,
    @SerializedName("image")val image: String,
    @SerializedName("listennotes_url") val listennotes_url: String,
    @SerializedName("name")val name: String,
    @SerializedName("podcast_count")  val podcast_count: Int,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("visibility") val visibility: String
)