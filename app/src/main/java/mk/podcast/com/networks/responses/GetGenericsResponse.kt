package mk.podcast.com.networks.responses

import com.google.gson.annotations.SerializedName

data class GetGenericsResponse(
    @SerializedName("genres")    val genres: List<GetGenericsResponse> ?=null
)