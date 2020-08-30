package mk.podcast.com.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import mk.padc.share.mvp.presenters.impl.BaseAppPresenterImpl
import mk.podcast.com.mvp.presenters.MainPresenter
import mk.podcast.com.mvp.views.MainView

class MainPresenterImpl : MainPresenter, BaseAppPresenterImpl<MainView>() {

 //   var mMovieImpl : MovieModel = MovieModelmpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        loadAllPodcastFromAPI()
        onNotifyCallMovieList(lifeCycleOwner)

     //   mView?.displayPodcastList(getDummyPodcastList())

    }

    override fun onTapPodCastListItem() {
      mView?.navigateToDetailScreen()
    }


    private fun onNotifyCallMovieList(lifeCycleOwner: LifecycleOwner)
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