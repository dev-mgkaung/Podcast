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
    var image: String? = "",
    var listennotes_url: String? = "",
    var publisher: String? = "",
    var thumbnail: String? = "",
    var title: String? = ""

)
