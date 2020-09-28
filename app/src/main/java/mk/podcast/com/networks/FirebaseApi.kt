package mk.podcast.com.networks

import mk.podcast.com.datas.vos.*

interface FirebaseApi {
    fun getCategoryList(
        onSuccess: (podcast: List<GenreVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getAllEpisodes(
        onSuccess: (playlist: List<EpisodeVO>) -> Unit,
        onFailure: (String) -> Unit
    )

}