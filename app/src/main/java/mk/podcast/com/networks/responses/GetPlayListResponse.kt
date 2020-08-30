package mk.podcast.com.networks.responses

import com.google.gson.annotations.SerializedName
import mk.podcast.com.datas.vos.PlayListVO

data class GetPlayListResponse(
    @SerializedName("has_next")     val has_next: Boolean,
    @SerializedName("has_previous")     val has_previous: Boolean,
    @SerializedName("next_page_number")  val next_page_number: Int,
    @SerializedName("page_number")   val page_number: Int,
    @SerializedName("playlists")   val playlists: List<PlayListVO>,
    @SerializedName("previous_page_number")    val previous_page_number: Int,
    @SerializedName("total")   val total: Int
)