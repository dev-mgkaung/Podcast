package mk.podcast.com.datas.models.impls

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import mk.podcast.com.datas.models.BaseModel
import mk.podcast.com.datas.models.PodcastModels
import mk.podcast.com.datas.vos.*
import mk.podcast.com.networks.FirebaseApi
import mk.podcast.com.networks.RealtimeDatabaseFirebaseApiImpl
import mk.podcast.com.utils.startDownloading


object PodcastFirebaseDataModelImpl : PodcastModels, BaseModel() {

    override var mFirebaseApi: FirebaseApi = RealtimeDatabaseFirebaseApiImpl
    override fun getCategoryList(
        onSuccess: (List<GenreVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getCategoryList(onSuccess = {
            mTheDB.generDao().insertGenerData(it)
        }, onFailure = { onFailure(it) })
    }

    override fun getRandomPodcast(
        onSuccess: (podcast: RandomPodcastVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getRandomPodcast(onSuccess = {
            mTheDB.randomPodCastDao().insertRandomPodcast(it)
        }, onFailure =
        { onFailure(it) })

    }

    override fun getPodcatPlayLists(
        onSuccess: (playlist: List<PlayListVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getPodcatPlayLists(onSuccess = {
            mTheDB.playListDao().insertPlayListData(it)
        }, onFailure =
        { onFailure(it) })
    }

    override fun getPodcastDetailById(
        podcastID: String,
        onSuccess: (playlist: DetailEpisodeVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseApi.getPodcastDetailById(podcastID, onSuccess = {
            mTheDB.detailDao().insertDetailData(it)
        },
            onFailure = { onFailure(it) })
    }

    override fun getAllPodCastDataList(onError: (String) -> Unit): LiveData<List<PodcastVO>> {
        return mTheDB.podcastDao().getAllPodcastData()
    }

    override fun getAllPodcastFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
    }

    override fun getAllPlayList(onError: (String) -> Unit): LiveData<List<PlayListVO>> {
        return mTheDB.playListDao().getAllPlayListData()
    }

    override fun getAllPlayListFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getDetailEpisodeData(
        episodeId: String,
        onError: (String) -> Unit
    ): LiveData<DetailEpisodeVO> {
        return mTheDB.detailDao().getAllDetailDataByEpisodeID(episodeId)

    }

    override fun getDetailFromApiAndSaveToDatabase(
        episodeId: String,
        onSuccess: (detailVO: DetailEpisodeVO) -> Unit,
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

    override fun getRandomPodcastData(onError: (String) -> Unit): LiveData<RandomPodcastVO> {
        return mTheDB.randomPodCastDao().getAllRandomPodCast()

    }

    override fun getRandomPodcastFromApiAndSaveToDatabase(
        onSuccess: (datavo: RandomPodcastVO) -> Unit,
        onError: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun startDownloadPodcast(context: Context, dataVO: DataVO) {
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