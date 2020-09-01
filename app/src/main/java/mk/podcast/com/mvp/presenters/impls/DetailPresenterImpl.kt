package mk.podcast.com.mvp.presenters.impls

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import mk.padc.share.mvp.presenters.impl.BaseAppPresenterImpl
import mk.podcast.com.datas.models.impls.PodcastModelmpl
import mk.podcast.com.mvp.presenters.DetailPresenter
import mk.podcast.com.mvp.views.DetailView

class DetailPresenterImpl : DetailPresenter, BaseAppPresenterImpl<DetailView>() {

    var mModelImpl : PodcastModelmpl = PodcastModelmpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner,episodeId: String) {
        loadAllDataFromAPI(episodeId)
        onNotifyCallDataList(lifeCycleOwner)
    }

    override fun onTap() {

    }


    private fun onNotifyCallDataList(lifeCycleOwner: LifecycleOwner)
    {
        //For Detail
        mModelImpl.getDetailEpisodeData (onError = {})
            .observe(lifeCycleOwner, Observer {
              mView?.displayDetailData(it)
            })

    }

    private fun loadAllDataFromAPI(episodeId : String) {
        //For Detail
        mModelImpl.getDetailFromApiAndSaveToDatabase(episodeId,onSuccess = {}, onError = {})
    }

}