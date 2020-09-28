package mk.podcast.com.networks.responses

import com.google.gson.annotations.SerializedName
import mk.podcast.com.datas.vos.EpisodeVO

data class GetPlayListResponse(
    @SerializedName("description") val description: String,
    @SerializedName("id") val id: String,
    @SerializedName("image") val image: String,
    @SerializedName("items") val items: List<EpisodeVO>,
    @SerializedName("last_timestamp_ms") val last_timestamp_ms: Long,
    @SerializedName("listennotes_url") val listennotes_url: String,
    @SerializedName("name") val name: String,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("total") val total: Int,
    @SerializedName("type") val type: String,
    @SerializedName("visibility") val visibility: String
)