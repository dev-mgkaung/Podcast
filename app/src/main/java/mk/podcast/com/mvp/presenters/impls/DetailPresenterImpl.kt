package mk.podcast.com.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import mk.padc.share.mvp.presenters.impl.BaseAppPresenterImpl
import mk.podcast.com.datas.dummy.getDummyPodcastList
import mk.podcast.com.mvp.presenters.DetailPresenter
import mk.podcast.com.mvp.views.DetailView


class DetailPresenterImpl : DetailPresenter, BaseAppPresenterImpl<DetailView>() {

    //   var mMovieImpl : MovieModel = MovieModelmpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        loadAllPodcastFromAPI()
        onNotifyDataList(lifeCycleOwner)

        mView?.displayData(getDummyPodcastList())

    }

    override fun onTap() {

    }


    private fun onNotifyDataList(lifeCycleOwner: LifecycleOwner)
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