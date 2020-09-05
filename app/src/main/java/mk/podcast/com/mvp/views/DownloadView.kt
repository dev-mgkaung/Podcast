package mk.podcast.com.mvp.views

import mk.padc.share.mvp.views.BaseView
import mk.podcast.com.datas.vos.DownloadVO
import mk.podcast.com.datas.vos.PodcastVO

interface DownloadView : BaseView {
    fun displayDownloadPodcastList(list: List<DownloadVO>)
    fun navigateToDetailScreen()
}