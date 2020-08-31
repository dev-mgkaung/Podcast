package mk.podcast.com.datas.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import mk.podcast.com.persistances.converters.ExtraConverter
import mk.podcast.com.persistances.converters.GenreIdListConverter
import mk.podcast.com.persistances.converters.LookingForConverter

@Entity(tableName = "podcast")
@TypeConverters(ExtraConverter::class, LookingForConverter::class,GenreIdListConverter::class)
data class PodcastVO(
    @PrimaryKey
    @SerializedName("id") var pid: String,
    @SerializedName("country") var country: String,
    @SerializedName("description") var description: String,
    @SerializedName("earliest_pub_date_ms") var earliest_pub_date_ms: Long,
    @SerializedName("email") var email: String,
    @SerializedName("explicit_content") var explicit_content: Boolean,
    @SerializedName("extra") var extra: Extra,
    @SerializedName("genre_ids") var genre_ids: List<Int>,
    @SerializedName("image") var image: String,
    @SerializedName("is_claimed") var is_claimed: Boolean,
    @SerializedName("itunes_id") var itunes_id: Int,
    @SerializedName("language") var language: String,
    @SerializedName("latest_pub_date_ms") var latest_pub_date_ms: Long,
    @SerializedName("listennotes_url") var listennotes_url: String,
    @SerializedName("looking_for") var looking_for: LookingFor,
    @SerializedName("publisher") var publisher: String,
    @SerializedName("rss") var rss: String,
    @SerializedName("thumbnail") var thumbnail: String,
    @SerializedName("title") var title: String,
    @SerializedName("total_episodes") var total_episodes: Int,
    @SerializedName("type") var type: String,
    @SerializedName("website") var website: String
)

data class LookingFor(
    @SerializedName("cohosts") val cohosts: Boolean,
    @SerializedName("cross_promotion") val cross_promotion: Boolean,
    @SerializedName("guests") val guests: Boolean,
    @SerializedName("sponsors")  val sponsors: Boolean
)

data class Extra(
    @SerializedName("facebook_handle") val facebook_handle: String,
    @SerializedName("google_url") val google_url: String,
    @SerializedName("instagram_handle") val instagram_handle: String,
    @SerializedName("linkedin_url") val linkedin_url: String,
    @SerializedName("patreon_handle") val patreon_handle: String,
    @SerializedName("spotify_url")  val spotify_url: String,
    @SerializedName("twitter_handle") val twitter_handle: String,
    @SerializedName("url1") val url1: String,
    @SerializedName("url2") val url2: String,
    @SerializedName("url3")val url3: String,
    @SerializedName("wechat_handle")val wechat_handle: String,
    @SerializedName("youtube_url") val youtube_url: String
)