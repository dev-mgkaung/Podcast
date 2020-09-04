package mk.podcast.com.mvp.views

import mk.padc.share.mvp.views.BaseView
import mk.podcast.com.datas.vos.DetailEpisodeVO
import mk.podcast.com.datas.vos.PodcastVO

interface DetailView : BaseView {
    fun displayDetailData(data: DetailEpisodeVO)
    fun onTouchPlayPauseIcon(audioUri : String)
    fun onTouchForwardThirtySecIcon()
    fun onTouchBackwardFifteenSecIcon()
}