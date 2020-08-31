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
        loadAllPodcastFromAPI()
        onNotifyCallMovieList(lifeCycleOwner)
    }

    override fun onTapPodCastListItem() {
      mView?.navigateToDetailScreen()
    }


    private fun onNotifyCallMovieList(lifeCycleOwner: LifecycleOwner)
    {
        //For PlayList
        mModelImpl.getAllPlayList(onError = {})
            .observe(lifeCycleOwner, Observer {
                mView?.displayPodcastList(it)
            })

    }

    private fun loadAllPodcastFromAPI() {
        //For PlayList
        mModelImpl.getAllPlayListFromApiAndSaveToDatabase(onSuccess = {}, onError = {})
    }

}