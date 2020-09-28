package mk.podcast.com.mvp.views

import mk.padc.share.mvp.views.BaseView
import mk.podcast.com.datas.vos.EpisodeVO

interface DetailView : BaseView {
    fun displayDetailData(data: EpisodeVO)
    fun onTouchPlayPauseIcon(audioUri: String)
    fun onTouchForwardThirtySecIcon()
    fun onTouchBackwardFifteenSecIcon()
}