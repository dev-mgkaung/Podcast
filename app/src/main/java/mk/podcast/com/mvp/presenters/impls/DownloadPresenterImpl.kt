package mk.podcast.com.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import mk.padc.share.mvp.presenters.impl.BaseAppPresenterImpl
import mk.podcast.com.datas.models.impls.PodcastModelmpl
import mk.podcast.com.mvp.presenters.DownloadPresenter
import mk.podcast.com.mvp.views.DownloadView


class DownloadPresenterImpl : DownloadPresenter, BaseAppPresenterImpl<DownloadView>() {

    var mModelImpl: PodcastModelmpl = PodcastModelmpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {

        mModelImpl.getDownloadPodcastList( onError = {})
            .observe(lifeCycleOwner, Observer {
                it?.let { mView?.displayDownloadPodcastList(it) }
            })

    }

    override fun onTapDownloadListItem() {}



}