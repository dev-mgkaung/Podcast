package mk.podcast.com.datas.vos


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.firebase.database.IgnoreExtraProperties
import mk.podcast.com.persistances.converters.GenreIdListConverter

@IgnoreExtraProperties

@Entity(tableName = "podcast")
@TypeConverters(GenreIdListConverter::class)
data class PodcastVO(
    @PrimaryKey
    var id: String = "",
    var country: String? = "",
    var description: String? = "",
    var earliest_pub_date_ms: Long? = 0,
    var email: String? = "",
    var explicit_content: Boolean? = false,
    var image: String? = "",
    var is_claimed: Boolean? = false,
    var itunes_id: Int? = 0,
    var language: String? = "",
    var latest_pub_date_ms: Long? = 0,
    var listennotes_url: String? = "",
    var publisher: String? = "",
    var rss: String? = "",
    var thumbnail: String? = "",
    var title: String? = "",
    var total_episodes: Int? = 0,
    var type: String? = "",
    var website: String? = ""
)
