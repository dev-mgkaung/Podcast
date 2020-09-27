package mk.podcast.com.datas.models

import android.content.Context
import androidx.lifecycle.LiveData
import mk.podcast.com.datas.vos.*
import mk.podcast.com.networks.FirebaseApi

interface PodcastModels {
    var mFirebaseApi: FirebaseApi

    fun getCategoryList(
        onSuccess: (categories: List<GenreVO>) -> Unit,
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


    //Podcast Data
    fun getAllPodCastDataList(onError: (String) -> Unit): LiveData<List<PodcastVO>>
    fun getAllPodcastFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    //PlayList Data
    fun getAllPlayList(onError: (String) -> Unit): LiveData<List<PlayListVO>>
    fun getAllPlayListFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    //Detail Episode Data
    fun getDetailEpisodeData(episodeId : String, onError: (String) -> Unit) : LiveData<DetailEpisodeVO>
    fun getDetailFromApiAndSaveToDatabase(episodeId : String, onSuccess: (detailVO :DetailEpisodeVO) -> Unit, onError: (String) -> Unit)

    //Category Genre Data
    fun getCategoryDataList(onError: (String) -> Unit) : LiveData<List<GenreVO>>
    fun getCategoryDataFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    //RandomPodcast Data
    fun getRandomPodcastData( onError: (String) -> Unit) : LiveData<RandomPodcastVO>
    fun getRandomPodcastFromApiAndSaveToDatabase( onSuccess: (datavo :RandomPodcastVO) -> Unit, onError: (String) -> Unit)

    //Download Podcast
    fun startDownloadPodcast(context: Context,dataVO: DataVO)
    fun getDownloadPodcastList(onError: (String) -> Unit) : LiveData<List<DownloadVO>>
    fun saveDownloadPodcastItem(donwloadVO: DownloadVO, onSuccess: () -> Unit, onError: (String) -> Unit)
}