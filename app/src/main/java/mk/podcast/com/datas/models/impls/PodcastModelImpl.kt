package mk.podcast.com.datas.models.impls

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
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

    override fun getAllPodcastFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {


    }

    override fun getAllPlayListList(onError: (String) -> Unit): LiveData<List<PlayListVO>> {
        return mTheDB.playListDao().getAllPlayListData()
    }

    override fun getAllPlayListFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

    }

    override fun getDetailEpisodeData(onError: (String) -> Unit): LiveData<DetailEpisodeVO> {
        return mTheDB.detailDao().getAllDetailData()
    }

    override fun getDetailFromApiAndSaveToDatabase(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

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