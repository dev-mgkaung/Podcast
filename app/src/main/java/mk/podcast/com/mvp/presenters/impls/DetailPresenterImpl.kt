package mk.podcast.com.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import mk.padc.share.mvp.presenters.impl.BaseAppPresenterImpl
import mk.podcast.com.datas.models.impls.PodcastFirebaseDataModelImpl
import mk.podcast.com.mvp.presenters.DetailPresenter
import mk.podcast.com.mvp.views.DetailView

class DetailPresenterImpl : DetailPresenter, BaseAppPresenterImpl<DetailView>() {

    var mModelImpl: PodcastFirebaseDataModelImpl = PodcastFirebaseDataModelImpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner, episodeID: String) {

        mModelImpl.getPodcastDetailById(episodeID, onSuccess = {
            mView?.displayDetailData(it)
        }, onFailure = {})

    }

    override fun  onTap() {}

    override fun onTouchPlayPause(audioUri : String) {
        mView?.onTouchPlayPauseIcon(audioUri)
    }

    override fun onTouchFifteenSec() {
        mView?.onTouchBackwardFifteenSecIcon()
    }

    override fun onTouchThirtySec() {
        mView?.onTouchForwardThirtySecIcon()
    }

}