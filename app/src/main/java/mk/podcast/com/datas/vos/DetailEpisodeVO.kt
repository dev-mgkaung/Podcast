package mk.podcast.com.datas.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import mk.podcast.com.persistances.converters.PodcastConverter

@Entity(tableName = "detail")
data class DetailEpisodeVO(
    @PrimaryKey
    @SerializedName("id") val id: String,
    @SerializedName("audio")  val audio: String,
    @SerializedName("audio_length_sec")  val audio_length_sec: Int,
    @SerializedName("description") val description: String,
    @SerializedName("explicit_content") val explicit_content: Boolean,
    @SerializedName("image")  val image: String,
    @SerializedName("link")   val link: String,
    @SerializedName("listennotes_edit_url") val listennotes_edit_url: String,
    @SerializedName("listennotes_url") val listennotes_url: String,
    @SerializedName("maybe_audio_invalid") val maybe_audio_invalid: Boolean,
   // @SerializedName("podcast") val podcast: PodcastVO,
    @SerializedName("pub_date_ms") val pub_date_ms: Long,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("title")  val title: String
)