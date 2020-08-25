package mk.podcast.com.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import mk.padc.share.mvp.presenters.BasePresenter
import mk.podcast.com.delegates.CategoryDelegate
import mk.podcast.com.mvp.views.CategoryView

interface CategoryPresenter : BasePresenter<CategoryView>, CategoryDelegate {
    fun onUiReady(lifeCycleOwner: LifecycleOwner)
}
