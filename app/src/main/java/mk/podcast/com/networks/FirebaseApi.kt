package mk.podcast.com.networks

import mk.podcast.com.datas.vos.DetailEpisodeVO
import mk.podcast.com.datas.vos.GenreVO
import mk.podcast.com.datas.vos.PlayListVO
import mk.podcast.com.datas.vos.RandomPodcastVO

interface FirebaseApi {
    fun getCategoryList(
        onSuccess: (podcast: List<GenreVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getRandomPodcast(
        onSuccess: (podcast: RandomPodcastVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getPodcatPlayLists(
        onSuccess: (playlist: List<PlayListVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getPodcastDetailById(
        podcastID: String,
        onSuccess: (playlist: DetailEpisodeVO) -> Unit,
        onFailure: (String) -> Unit
    )
}