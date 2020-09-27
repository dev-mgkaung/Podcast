package mk.podcast.com.datas.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName
import mk.podcast.com.persistances.converters.PodCastVOConverter

@IgnoreExtraProperties
@Entity(tableName = "detail")
@TypeConverters(PodCastVOConverter::class)
data class DetailEpisodeVO(
    @PrimaryKey
    val id: String,
    val audio: String,
    val audio_length_sec: Long,
    val description: String,
    val explicit_content: Boolean,
    val image: String,
    val link: String,
    val listennotes_edit_url: String,
    val listennotes_url: String,
    val maybe_audio_invalid: Boolean,
    val podcast: PodcastVO,
    val pub_date_ms: Long,
    val thumbnail: String,
    val title: String
)