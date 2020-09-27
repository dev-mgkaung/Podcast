package mk.podcast.com.mvp.presenters.impls

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import mk.padc.share.mvp.presenters.impl.BaseAppPresenterImpl
import mk.podcast.com.datas.models.impls.PodcastFirebaseDataModelImpl
import mk.podcast.com.datas.vos.DataVO
import mk.podcast.com.datas.vos.DownloadVO
import mk.podcast.com.datas.vos.PlayListVO
import mk.podcast.com.mvp.presenters.MainPresenter
import mk.podcast.com.mvp.views.MainView

class MainPresenterImpl : MainPresenter, BaseAppPresenterImpl<MainView>() {

    var mModelImpl: PodcastFirebaseDataModelImpl = PodcastFirebaseDataModelImpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {

        mModelImpl.getPodcatPlayLists(onSuccess = {}, onFailure = {})

        mModelImpl.getRandomPodcast(onSuccess = {}, onFailure = {})

        mModelImpl.getAllPlayList(onError = {})
            .observe(lifeCycleOwner, Observer {
                it?.let {
                    mView?.displayPodcastList(it)
                }
            })
        mModelImpl.getRandomPodcastData(onError = {})
            .observe(lifeCycleOwner, Observer {
                it?.let {
                    mView?.displayRandomPodcastData(it)
                }
            })
    }

    override fun onTapPlayListItem(playListVO: PlayListVO) {
        mView?.navigateToDetailScreen(playListVO.data?.id)
    }

    override fun onTapDownloadPodcastItem(dataVO: DataVO?) {

        val downloadVO: DownloadVO = DownloadVO(
            dataVO!!.id.toString(), dataVO?.title, dataVO?.description,
            dataVO?.thumbnail, dataVO?.title?.trim()!!.substring(0, 8)
        )

        mModelImpl?.saveDownloadPodcastItem(downloadVO, onSuccess = {}, onError = {})
        mView?.selectedDownloadPodcastItem(dataVO)
    }

    override fun onDownloadPodcastItem(context: Context, dataVO: DataVO) {
        mModelImpl.startDownloadPodcast(context, dataVO)
    }

    override fun onTapFindSomethingNew() {}

    override fun onTapReload() {}

    override fun onTouchPlayPause(audioUrl: String) {
        mView?.onTouchPlayPauseImage(audioUrl)
    }


    override fun onTouchFifteenSec() {
        mView?.onTouchBackwardFifteenSecIcon()
    }

    override fun onTouchThirtySec() {
        mView?.onTouchForwardThirtySecIcon()
    }

}