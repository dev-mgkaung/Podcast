package mk.podcast.com.networks.responses

import com.google.gson.annotations.SerializedName
import mk.podcast.com.datas.vos.GenreVO

data class GetGenericsResponse(
    @SerializedName("genres")    val genres: List<GenreVO>
)