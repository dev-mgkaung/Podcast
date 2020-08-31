package mk.podcast.com.datas.models

import androidx.lifecycle.LiveData
import mk.podcast.com.datas.vos.DetailEpisodeVO
import mk.podcast.com.datas.vos.GenreVO
import mk.podcast.com.datas.vos.PlayListVO
import mk.podcast.com.datas.vos.PodcastVO

interface PodcastModels
{
    //Podcast Data
    fun getAllPodCastDataList(onError: (String) -> Unit) : LiveData<List<PodcastVO>>
    fun getAllPodcastFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    //PlayList Data
    fun getAllPlayList(onError: (String) -> Unit) : LiveData<List<PlayListVO>>
    fun getAllPlayListFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    //Detail Episode Data
    fun getDetailEpisodeData(onError: (String) -> Unit) : LiveData<DetailEpisodeVO>
    fun getDetailFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

    //Category Data
    fun getCategoryDataList(onError: (String) -> Unit) : LiveData<List<GenreVO>>
    fun getCategoryDataFromApiAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)

}