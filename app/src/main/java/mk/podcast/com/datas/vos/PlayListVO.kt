package mk.podcast.com.datas.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.firebase.database.IgnoreExtraProperties
import mk.podcast.com.persistances.converters.DataConverter
import mk.podcast.com.persistances.converters.PodCastVOConverter

@IgnoreExtraProperties
@Entity(tableName = "playlist")
@TypeConverters(DataConverter::class, PodCastVOConverter::class)
data class PlayListVO(
    @PrimaryKey
    val plid: Int,
    val added_at_ms: Long,
    val data: DataVO,
    val notes: String,
    val type: String
)

data class DataVO(
    var data_id: String,
    var audio: String,
    var audio_length_sec: Int,
    var description: String,
    var explicit_content: Boolean,
    var image: String,
    var link: String,
    var listennotes_edit_url: String,
    var listennotes_url: String,
    var maybe_audio_invarid: Boolean,
    var podcast: PodcastVO,
    var pub_date_ms: Long,
    var thumbnail: String,
    var title: String
)

