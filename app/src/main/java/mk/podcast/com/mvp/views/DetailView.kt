package mk.podcast.com.mvp.views

import mk.padc.share.mvp.views.BaseView
import mk.podcast.com.datas.vos.PodcastVO

interface DetailView : BaseView {
    fun displayData(list: List<PodcastVO>)
}