package mk.podcast.com.datas.models.impls

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mk.padc.themovie.utils.EM_NO_INTERNET_CONNECTION
import mk.padc.themovie.utils.PARAM_API_ACCESS_TOKEN
import mk.padc.themovie.utils.playlistId
import mk.podcast.com.datas.models.BaseModel
import mk.podcast.com.datas.models.PodcastModels
import mk.podcast.com.datas.vos.DetailEpisodeVO
import mk.podcast.com.datas.vos.GenreVO
import mk.podcast.com.datas.vos.PlayListVO
import mk.podcast.com.datas.vos.PodcastVO

object PodcastModelmpl : PodcastModels, BaseModel() {

    override fun getAllPodCastDataList(onError: (String) -> Unit): LiveData<List<PodcastVO>> {
        return mTheDB.podcastDao().getAllPodcastData()
    }

    @SuppressLint("CheckResult")
    override fun getAllPodcastFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {



    }

    override fun getAllPlayList(onError: (String) -> Unit): LiveData<List<PlayListVO>> {
        return mTheDB.playListDao().getAllPlayListData()
    }

    @SuppressLint("CheckResult")
    override fun getAllPlayListFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mApi.fetchPlayList(PARAM_API_ACCESS_TOKEN,playlistId)
            .map { it.items.toList() ?: listOf() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                mTheDB.playListDao().insertPlayListData(it)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getDetailEpisodeData(onError: (String) -> Unit): LiveData<DetailEpisodeVO> {
        return mTheDB.detailDao().getAllDetailData()
    }

    @SuppressLint("CheckResult")
    override fun getDetailFromApiAndSaveToDatabase(
        episodeId: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mApi.fetchDetailEpisodeByID(PARAM_API_ACCESS_TOKEN,"c2db92a9cc45462385866e6b45f91ef9")
            .map { it }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                mTheDB.detailDao().insertDetailData(it)
            },{
                onError(it.localizedMessage ?: EM_NO_INTERNET_CONNECTION)
            })
    }

    override fun getCategoryDataList(onError: (String) -> Unit): LiveData<List<GenreVO>> {
        return mTheDB.generDao().getAllGenerData()
    }

    override fun getCategoryDataFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

    }


}