package mk.podcast.com.datas.vos


import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class PodcastVO(

    var pid: String? = "",
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
) {

    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "pid" to pid,
            "country" to country,
            "description" to description,
            "earliest_pub_date_ms" to earliest_pub_date_ms,
            "email" to email,
            "explicit_content" to explicit_content,
            "image" to image,
            "is_claimed" to is_claimed,
            "itunes_id" to itunes_id,
            "language" to language,
            "latest_pub_date_ms" to latest_pub_date_ms,
            "listennotes_url" to listennotes_url,
            "publisher" to publisher,
            "thumbnail" to thumbnail,
            "title" to title,
            "total_episodes" to total_episodes,
            "type" to type,
            "website" to website
        )
    }

}
