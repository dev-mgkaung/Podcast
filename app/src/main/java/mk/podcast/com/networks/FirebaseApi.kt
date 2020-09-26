package mk.podcast.com.networks

import mk.podcast.com.datas.vos.DetailEpisodeVO
import mk.podcast.com.datas.vos.GenreVO
import mk.podcast.com.datas.vos.PlayListVO
import mk.podcast.com.datas.vos.RandomPodcastVO

interface FirebaseApi {
    fun getCategoryList(
        onSuccess: (podcast: List<GenreVO>) -> Unit,
        onFialure: (String) -> Unit
    )

    fun getRandomPodcast(
        onSuccess: (podcast: List<RandomPodcastVO>) -> Unit,
        onFialure: (String) -> Unit
    )

    fun getPodcatPlayLists(
        onSuccess: (playlist: List<PlayListVO>) -> Unit,
        onFialure: (String) -> Unit
    )

    fun getPodcastDetailById(
        podcastID: String,
        onSuccess: (playlist: List<DetailEpisodeVO>) -> Unit,
        onFialure: (String) -> Unit
    )
}