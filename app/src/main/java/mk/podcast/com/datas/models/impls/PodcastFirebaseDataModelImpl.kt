package mk.podcast.com.datas.models.impls

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import mk.podcast.com.datas.models.BaseModel
import mk.podcast.com.datas.models.PodcastModels
import mk.podcast.com.datas.vos.*
import mk.podcast.com.networks.ColudFirebaseDatabaseApiImpl
import mk.podcast.com.networks.FirebaseApi
import mk.podcast.com.networks.RealtimeDatabaseFirebaseApiImpl
import mk.podcast.com.utils.startDownloading


object PodcastFirebaseDataModelImpl : PodcastModels, BaseModel() {

    //  override var mFirebaseApi: FirebaseApi = RealtimeDatabaseFirebaseApiImpl
    override var mFirebaseApi: FirebaseApi = ColudFirebaseDatabaseApiImpl

    override fun getCategoryListFromFirebase(
        onSuccess: (List<GenreVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getCategoryList(onSuccess = {
            mTheDB.generDao().insertGenerData(it)
        }, onFailure = { onFailure(it) })
    }


    override fun getAllEpisodesFromFirebase(
        onSuccess: (playlist: List<EpisodeVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getAllEpisodes(onSuccess = {
            mTheDB.episodeDao().insertAllEpisodes(it)
        }, onFailure =
        { onFailure(it) })
    }


    override fun getAllPodCastDataList(onError: (String) -> Unit): LiveData<List<PodcastVO>> {
        return mTheDB.podcastDao().getAllPodcastData()
    }

    override fun getAllPodcastFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
    }

    override fun getAllEpisodeFromDB(onError: (String) -> Unit): LiveData<List<EpisodeVO>> {
        return mTheDB.episodeDao().getAllEpisodes()
    }

    override fun getAllPlayListFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getEpisodeDataByID(
        episodeId: String,
        onError: (String) -> Unit
    ): LiveData<EpisodeVO> {
        return mTheDB.episodeDao().getAllDetailDataByEpisodeID(episodeId)
    }

    override fun getDetailFromApiAndSaveToDatabase(
        episodeId: String,
        onSuccess: (detailVO: EpisodeVO) -> Unit,
        onError: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getCategoryDataList(onError: (String) -> Unit): LiveData<List<GenreVO>> {
        return mTheDB.generDao().getAllGenerData()
    }

    override fun getCategoryDataFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getRandomPodcastData(onError: (String) -> Unit): LiveData<List<EpisodeVO>> {
        return mTheDB.episodeDao().getAllEpisodes()
    }

    override fun getRandomPodcastFromApiAndSaveToDatabase(
        onSuccess: (datavo: EpisodeVO) -> Unit,
        onError: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun startDownloadPodcast(context: Context, dataVO: EpisodeVO) {
        Toast.makeText(context, "Start Downloading", Toast.LENGTH_LONG).show()
        startDownloading(context, dataVO)
    }

    override fun getDownloadPodcastList(onError: (String) -> Unit): LiveData<List<DownloadVO>> {
        return mTheDB.downloadDao().getAllDownloadPodcastData()
    }

    override fun saveDownloadPodcastItem(
        donwloadVO: DownloadVO,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mTheDB.downloadDao().insertDownloadPodcastData(donwloadVO)
    }
}