package mk.podcast.com.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import mk.padc.share.mvp.presenters.BasePresenter
import mk.podcast.com.delegates.DetailDelegate
import mk.podcast.com.mvp.views.DetailView
import mk.podcast.com.views.viewpods.MiniMusicPlayerViewPod

interface DetailPresenter : BasePresenter<DetailView>, DetailDelegate,MiniMusicPlayerViewPod.Delegate {
    fun onUiReady(lifeCycleOwner: LifecycleOwner, episodeID: String)
}
