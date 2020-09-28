package mk.podcast.com.datas.models.impls

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mk.padc.themovie.utils.EM_NO_INTERNET_CONNECTION
import mk.padc.themovie.utils.PARAM_API_ACCESS_TOKEN
import mk.padc.themovie.utils.playlistId
import mk.padc.themovie.utils.top_level_only
import mk.podcast.com.datas.models.BaseModel
import mk.podcast.com.datas.models.PodcastModels
import mk.podcast.com.datas.vos.*
import mk.podcast.com.networks.FirebaseApi
import mk.podcast.com.networks.PodcastApi
import mk.podcast.com.utils.startDownloading

object PodcastModelmpl : PodcastModels, BaseModel() {

    override var mFirebaseApi: FirebaseApi
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun getCategoryListFromFirebase(
        onSuccess: (categories: List<GenreVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getAllEpisodesFromFirebase(
        onSuccess: (episodes: List<EpisodeVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        TODO("Not yet implemented")
    }


    override fun getAllPodCastDataList(onError: (String) -> Unit): LiveData<List<PodcastVO>> {
        // return mTheDB.podcastDao().getAllPodcastData()
        TODO("Not yet implemented")
    }

    @SuppressLint("CheckResult")
    override fun getAllPodcastFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
    }

    override fun getAllEpisodeFromDB(onError: (String) -> Unit): LiveData<List<EpisodeVO>> {
        TODO("Not yet implemented")
    }


//    override fun getAllPlayList(onError: (String) -> Unit): LiveData<List<PlayListVO>> {
//       // return mTheDB.episodeDao().getAllEpisodes()
//        TODO("Not yet implemented")
//    }

    @SuppressLint("CheckResult")
    override fun getAllPlayListFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
//        mApi.fetchPlayList(PARAM_API_ACCESS_TOKEN, playlistId)
//            .map { it.items.toList() ?: listOf() }
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                mTheDB.episodeDao().insertAllEpisodes(it)
//            }, {
//                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
//            })
        TODO("Not yet implemented")
    }

    override fun getEpisodeDataByID(
        episodeId: String,
        onError: (String) -> Unit
    ): LiveData<EpisodeVO> {
        //    return mTheDB.detailDao().getAllDetailDataByEpisodeID(episodeId)
        TODO("Not yet implemented")
    }

    @SuppressLint("CheckResult")
    override fun saveDownloadPodcastItem(
        downloadVO: DownloadVO,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mTheDB.downloadDao().insertDownloadPodcastData(downloadVO)
     }

    @SuppressLint("CheckResult")
    override fun getDetailFromApiAndSaveToDatabase(
        episodeId: String,
        onSuccess: (EpisodeVO) -> Unit,
        onError: (String) -> Unit
    ) {
        mApi.fetchDetailEpisodeByID(PARAM_API_ACCESS_TOKEN, episodeId)
            .map { it }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                // mTheDB.episodeDao().insertAllEpisodes(it)
            }, {
                // onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
        TODO("Not yet implemented")
    }

    override fun getCategoryDataList(onError: (String) -> Unit): LiveData<List<GenreVO>> {
        return mTheDB.generDao().getAllGenerData()
    }

    @SuppressLint("CheckResult")
    override fun getCategoryDataFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mApi.fetchPodcastGenresList(PARAM_API_ACCESS_TOKEN, top_level_only)
            .map { it.genres.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { mTheDB.generDao().insertGenerData(it) }
            }, {
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getRandomPodcastData(onError: (String) -> Unit): LiveData<List<EpisodeVO>> {
        TODO("Not yet implemented")
    }


    @SuppressLint("CheckResult")
    override fun getRandomPodcastFromApiAndSaveToDatabase(
        onSuccess: (datavo: EpisodeVO) -> Unit,
        onError: (String) -> Unit
    ) {
//        mApi.fetchRandomPodcastEpisode(PARAM_API_ACCESS_TOKEN)
//            .map { it }
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                it?.let { data ->
//                    mTheDB.episodeDao().insertAllEpisodes(data)
//                }
//            }, {
//                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
//            })
        TODO("Not yet implemented")
    }

    override fun startDownloadPodcast(context: Context, dataVO: EpisodeVO) {
        Toast.makeText(context, "Start Downloading", Toast.LENGTH_LONG).show()
        startDownloading(context, dataVO)
    }

    override fun getDownloadPodcastList(onError: (String) -> Unit): LiveData<List<DownloadVO>> {
        return mTheDB.downloadDao().getAllDownloadPodcastData()
    }

}