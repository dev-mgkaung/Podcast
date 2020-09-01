package mk.podcast.com.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import mk.padc.share.mvp.presenters.impl.BaseAppPresenterImpl
import mk.podcast.com.datas.models.impls.PodcastModelmpl
import mk.podcast.com.mvp.presenters.DetailPresenter
import mk.podcast.com.mvp.views.DetailView

class DetailPresenterImpl : DetailPresenter, BaseAppPresenterImpl<DetailView>() {

    var mModelImpl : PodcastModelmpl = PodcastModelmpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner, episodeID: String) {

        mModelImpl.getDetailFromApiAndSaveToDatabase(episodeID,onSuccess = {
           //mView?.displayDetailData(it)
        }, onError = {})

//        mModelImpl.getDetailEpisodeData (episodeID,onError = {})
//            .observe(lifeCycleOwner, Observer {
//                mView?.displayDetailData(it)
//            })
    }

    override fun onTap() {}



}