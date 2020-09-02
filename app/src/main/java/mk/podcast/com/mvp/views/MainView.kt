package mk.podcast.com.mvp.views

import android.content.Context
import mk.padc.share.mvp.views.BaseView
import mk.podcast.com.datas.vos.DataVO
import mk.podcast.com.datas.vos.PlayListVO
import mk.podcast.com.datas.vos.RandomPodcastVO

interface MainView : BaseView {
    fun displayPodcastList(list: List<PlayListVO>)
    fun displayRandomPodcastData (data : RandomPodcastVO)
    fun navigateToDetailScreen(episodeID : String)
    fun selectedDownloadPodcastItem(data: DataVO)

}