package mk.podcast.com.mvp.presenters

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import mk.padc.share.mvp.presenters.BasePresenter
import mk.podcast.com.datas.vos.EpisodeVO
import mk.podcast.com.delegates.PodcastDelegate
import mk.podcast.com.mvp.views.MainView
import mk.podcast.com.views.viewpods.EmptyViewPod
import mk.podcast.com.views.viewpods.MusicPlayerPlayerViewPod

interface MainPresenter : BasePresenter<MainView>, PodcastDelegate, EmptyViewPod.Delegate, MusicPlayerPlayerViewPod.Delegate {
    fun onUiReady(lifeCycleOwner: LifecycleOwner)
    fun onDownloadPodcastItem(context: Context, dataVO: EpisodeVO)
}
