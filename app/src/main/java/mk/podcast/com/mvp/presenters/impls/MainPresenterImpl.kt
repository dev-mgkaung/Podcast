package mk.podcast.com.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import mk.padc.share.mvp.presenters.impl.BaseAppPresenterImpl
import mk.podcast.com.datas.models.impls.PodcastModelmpl
import mk.podcast.com.mvp.presenters.MainPresenter
import mk.podcast.com.mvp.views.MainView

class MainPresenterImpl : MainPresenter, BaseAppPresenterImpl<MainView>() {

    var mModelImpl : PodcastModelmpl = PodcastModelmpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        loadAllDataFromAPI()
        onNotifyCallDataList(lifeCycleOwner)
    }

    override fun onTapPlayListItem() {
      mView?.navigateToDetailScreen()
    }

    override fun onDownloadPodcastItem() {

    }

    override fun onTapFindSomethingNew() {

    }

    override fun onTapReload() {

    }


    private fun onNotifyCallDataList(lifeCycleOwner: LifecycleOwner)
    {
        //For PlayList
        mModelImpl.getAllPlayList(onError = {})
            .observe(lifeCycleOwner, Observer {
                mView?.displayPodcastList(it)
            })

    }

    private fun loadAllDataFromAPI() {
        //For PlayList
        mModelImpl.getAllPlayListFromApiAndSaveToDatabase(onSuccess = {}, onError = {})
    }

}