package mk.podcast.com.datas.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "podcast")
data class PodcastVO(
    @PrimaryKey
    @SerializedName("id") val id: String, val country: String,
    @SerializedName("description")  val description: String,
    @SerializedName("earliest_pub_date_ms") val earliest_pub_date_ms: Long,
    @SerializedName("email")val email: String,
    @SerializedName("explicit_content") val explicit_content: Boolean,
   // @SerializedName("extra") val extra: Extra,
   // @SerializedName("genre_ids") val genre_ids: List<Int>,
    @SerializedName("image")val image: String,
    @SerializedName("is_claimed") val is_claimed: Boolean,
    @SerializedName("itunes_id") val itunes_id: Int,
    @SerializedName("language")val language: String,
    @SerializedName("latest_pub_date_ms")val latest_pub_date_ms: Long,
    @SerializedName("listennotes_url") val listennotes_url: String,
    //@SerializedName("looking_for")  val looking_for: LookingFor,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("rss")  val rss: String,
    @SerializedName("thumbnail")  val thumbnail: String,
    @SerializedName("title") val title: String,
    @SerializedName("total_episodes") val total_episodes: Int,
    @SerializedName("type") val type: String,
    @SerializedName("website") val website: String
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