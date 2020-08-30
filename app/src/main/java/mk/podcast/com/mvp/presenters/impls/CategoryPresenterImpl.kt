package mk.podcast.com.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import mk.padc.share.mvp.presenters.impl.BaseAppPresenterImpl
import mk.podcast.com.mvp.presenters.CategoryPresenter
import mk.podcast.com.mvp.views.CategoryView

class CategoryPresenterImpl : CategoryPresenter, BaseAppPresenterImpl<CategoryView>() {

    //   var mMovieImpl : MovieModel = MovieModelmpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        loadAllPodcastFromAPI()
        onNotifyCallDataList(lifeCycleOwner)

      //  mView?.displayCategoryList(getDummyCategoryList())

    }

    override fun onTapCategoryListItem() {

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