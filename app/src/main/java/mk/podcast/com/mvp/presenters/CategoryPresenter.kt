package mk.podcast.com.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import mk.padc.share.mvp.presenters.BasePresenter
import mk.podcast.com.delegates.CategoryDelegate
import mk.podcast.com.mvp.views.CategoryView
import mk.podcast.com.views.viewpods.EmptyViewPod

interface CategoryPresenter : BasePresenter<CategoryView>, CategoryDelegate, EmptyViewPod.Delegate {
    fun onUiReady(lifeCycleOwner: LifecycleOwner)
}
