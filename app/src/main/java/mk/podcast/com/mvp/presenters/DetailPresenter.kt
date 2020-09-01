package mk.podcast.com.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import mk.padc.share.mvp.presenters.BasePresenter
import mk.podcast.com.delegates.DetailDelegate
import mk.podcast.com.mvp.views.DetailView

interface DetailPresenter : BasePresenter<DetailView>, DetailDelegate {
    fun onUiReady(lifeCycleOwner: LifecycleOwner, episodeID: String)
}
