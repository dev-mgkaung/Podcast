package mk.podcast.com.datas.models

import android.content.Context
import androidx.lifecycle.LiveData
import mk.podcast.com.datas.vos.*
import mk.podcast.com.networks.FirebaseApi

interface PodcastModels {
    var mFirebaseApi: FirebaseApi

    fun getCategoryListFromFirebase(
        onSuccess: (categories: List<GenreVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getAllEpisodesFromFirebase(
        onSuccess: (episodes: List<EpisodeVO>) -> Unit,
        onFailure: (String) -> Unit
    )


    //Podcast Data
    fun getAllPodCastDataList(onError: (String) -> Unit): LiveData<List<PodcastVO>>
    fun getAllPodcastFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    //PlayList Data
    fun getAllEpisodeFromDB(onError: (String) -> Unit): LiveData<List<EpisodeVO>>
    fun getAllPlayListFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    //Detail Episode Data
    fun getEpisodeDataByID(episodeId: String, onError: (String) -> Unit): LiveData<EpisodeVO>
    fun getDetailFromApiAndSaveToDatabase(
        episodeId: String,
        onSuccess: (detailVO: EpisodeVO) -> Unit,
        onError: (String) -> Unit
    )

    //Category Genre Data
    fun getCategoryDataList(onError: (String) -> Unit): LiveData<List<GenreVO>>
    fun getCategoryDataFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    //RandomPodcast Data
    fun getRandomPodcastData(onError: (String) -> Unit): LiveData<EpisodeVO>
    fun getRandomPodcastFromApiAndSaveToDatabase(
        onSuccess: (datavo: EpisodeVO) -> Unit,
        onError: (String) -> Unit
    )

    //Download Podcast
    fun startDownloadPodcast(context: Context, dataVO: EpisodeVO)
    fun getDownloadPodcastList(onError: (String) -> Unit): LiveData<List<DownloadVO>>
    fun saveDownloadPodcastItem(
        donwloadVO: DownloadVO,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    )
}