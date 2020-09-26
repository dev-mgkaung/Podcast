package mk.podcast.com.networks

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import mk.podcast.com.datas.vos.DetailEpisodeVO
import mk.podcast.com.datas.vos.PlayListVO
import mk.podcast.com.datas.vos.RandomPodcastVO
import mk.podcast.com.networks.responses.GetPlayListResponse


object RealtimeDatabaseFirebaseApiImpl : FirebaseApi {

    private val database: DatabaseReference = Firebase.database.reference
    override fun getCategoryList(
        onSuccess: (podcast: List<RandomPodcastVO>) -> Unit,
        onFialure: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getRandomPodcast(
        onSuccess: (podcast: List<RandomPodcastVO>) -> Unit,
        onFialure: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getPodcatPlayLists(
        onSuccess: (playlist: List<PlayListVO>) -> Unit,
        onFialure: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getPodcastDetailById(
        podcastID: String,
        onSuccess: (playlist: List<DetailEpisodeVO>) -> Unit,
        onFialure: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }


}