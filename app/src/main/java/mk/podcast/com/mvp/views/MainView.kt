package mk.podcast.com.mvp.views

import mk.padc.share.mvp.views.BaseView
import mk.podcast.com.datas.vos.EpisodeVO

interface MainView : BaseView {
    fun displayPodcastList(list: List<EpisodeVO>)
    fun displayRandomPodcastData(data: EpisodeVO)
    fun navigateToDetailScreen(episodeID: String?)
    fun selectedDownloadPodcastItem(data: EpisodeVO)
    fun onTouchPlayPauseImage(audioUrl: String)
    fun onTouchForwardThirtySecIcon()
    fun onTouchBackwardFifteenSecIcon()
}