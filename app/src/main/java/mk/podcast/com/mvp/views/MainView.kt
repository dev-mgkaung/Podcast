package mk.podcast.com.mvp.views

import mk.padc.share.mvp.views.BaseView
import mk.podcast.com.datas.vos.PlayListVO

interface MainView : BaseView {
    fun displayPodcastList(list: List<PlayListVO>)
    fun navigateToDetailScreen(episodeID : String)
}