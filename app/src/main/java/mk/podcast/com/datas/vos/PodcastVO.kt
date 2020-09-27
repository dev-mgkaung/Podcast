package mk.podcast.com.datas.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName
import mk.podcast.com.persistances.converters.ExtraConverter
import mk.podcast.com.persistances.converters.GenreIdListConverter
import mk.podcast.com.persistances.converters.LookingForConverter

@IgnoreExtraProperties
//@Entity(tableName = "podcast")
//@TypeConverters(ExtraConverter::class, LookingForConverter::class, GenreIdListConverter::class)
data class PodcastVO(

    var pid: String? = "",
    var country: String? = "",
    var description: String? = "",
    var earliest_pub_date_ms: Long? = 0,
    var email: String? = "",
    var explicit_content: Boolean? = false,
    //  var extra: Extra ?= null,
    // var genre_ids: List<Int> ?= null,
    var image: String? = "",
    var is_claimed: Boolean? = false,
    var itunes_id: Int? = 0,
    var language: String? = "",
    var latest_pub_date_ms: Long? = 0,
    var listennotes_url: String? = "",
    // var looking_for: LookingFor ?= null,
    var publisher: String? = "",
    var rss: String? = "",
    var thumbnail: String? = "",
    var title: String? = "",
    var total_episodes: Int? = 0,
    var type: String? = "",
    var website: String? = ""
) {
    @PrimaryKey(autoGenerate = true)
    var podcastsId: Int = 0
}

@IgnoreExtraProperties
data class LookingFor(
    var cohosts: Boolean? = false,
    var cross_promotion: Boolean? = false,
    var guests: Boolean? = false,
    var sponsors: Boolean? = false
)

@IgnoreExtraProperties
data class Extra(
    var facebook_handle: String? = "",
    var google_url: String? = "",
    var instagram_handle: String? = "",
    var linkedin_url: String? = "",
    var patreon_handle: String? = "",
    var spotify_url: String? = "",
    var twitter_handle: String? = "",
    var url1: String? = "",
    var url2: String? = "",
    var url3: String? = "",
    var wechat_handle: String? = "",
    var youtube_url: String? = ""
)