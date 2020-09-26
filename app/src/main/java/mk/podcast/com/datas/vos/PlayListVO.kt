package mk.podcast.com.datas.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import mk.podcast.com.persistances.converters.DataConverter
import mk.podcast.com.persistances.converters.PodCastVOConverter

@Entity(tableName = "playlist")
@TypeConverters(DataConverter::class, PodCastVOConverter::class)
data class PlayListVO(
    @PrimaryKey
    @SerializedName("id") val plid: Int,
    @SerializedName("added_at_ms") val added_at_ms: Long,
    @SerializedName("data") val data: DataVO,
    @SerializedName("notes") val notes: String,
    @SerializedName("type") val type: String
)

data class DataVO(
    @SerializedName("id")var data_id: String,
    @SerializedName("audio")var audio: String,
    @SerializedName("audio_length_sec")var audio_length_sec: Int,
    @SerializedName("description")var description: String,
    @SerializedName("explicit_content")var explicit_content: Boolean,
    @SerializedName("image")var image: String,
    @SerializedName("link")var link: String,
    @SerializedName("listennotes_edit_url")var listennotes_edit_url: String,
    @SerializedName("listennotes_url")var listennotes_url: String,
    @SerializedName("maybe_audio_invarid")var maybe_audio_invarid: Boolean,
    @SerializedName("podcast")var podcast: PodcastVO,
    @SerializedName("pub_date_ms")var pub_date_ms: Long,
    @SerializedName("thumbnail")var thumbnail: String,
    @SerializedName("title")var title: String
)

