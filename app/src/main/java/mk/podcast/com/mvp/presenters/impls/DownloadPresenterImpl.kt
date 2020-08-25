package mk.podcast.com.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import mk.padc.share.mvp.presenters.impl.BaseAppPresenterImpl
import mk.podcast.com.datas.dummy.getDummyPodcastList
import mk.podcast.com.mvp.presenters.DownloadPresenter
import mk.podcast.com.mvp.views.DownloadView


class DownloadPresenterImpl : DownloadPresenter, BaseAppPresenterImpl<DownloadView>() {

    //   var mMovieImpl : MovieModel = MovieModelmpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        loadAllPodcastFromAPI()
        onNotifyCallDataList(lifeCycleOwner)

        mView?.displayDownloadPodcastList(getDummyPodcastList())

    }

    override fun onTapDownloadListItem() {

    }


    private fun onNotifyCallDataList(lifeCycleOwner: LifecycleOwner)
    {
//        mMovieImpl.getAllPopularMovieList(onError = {})
//            .observe(lifeCycleOwner, Observer {
//                mView?.displayPopularMovieList(it)
//            })

    }

    private fun loadAllPodcastFromAPI() {
//        mMovieImpl.getAllPopularMovieFromApiAndSaveToDatabase(
//            onSuccess = {},
//            onError = {}
//        )
//
    }

}