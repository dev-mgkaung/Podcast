package mk.podcast.com.datas.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName
import mk.podcast.com.persistances.converters.PodCastVOConverter

@IgnoreExtraProperties
//@Entity(tableName = "randompodcast")
//@TypeConverters( PodCastVOConverter::class)

data class RandomPodcastVO(
    var id: String? = "",
    var audio: String? = "",
    var audio_length_sec: Int? = 0,
    var description: String? = "",
    var explicit_content: Boolean? = false,
    var image: String? = "",
    var link: String? = "",
    var listennotes_edit_url: String? = "",
    var listennotes_url: String? = "",
    var maybe_audio_invalid: Boolean? = false,
    //var podcast: HashMap<String, PodcastVO> = hashMapOf() ,
    var pub_date_ms: Long? = 0,
    var thumbnail: String? = "",
    var title: String? = ""
) {
    @PrimaryKey(autoGenerate = true)
    var podcastId: Int = 0
}
