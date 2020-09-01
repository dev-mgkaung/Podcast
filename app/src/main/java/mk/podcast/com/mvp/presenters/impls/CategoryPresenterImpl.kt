package mk.podcast.com.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import mk.padc.share.mvp.presenters.impl.BaseAppPresenterImpl
import mk.podcast.com.datas.models.impls.PodcastModelmpl
import mk.podcast.com.mvp.presenters.CategoryPresenter
import mk.podcast.com.mvp.views.CategoryView

class CategoryPresenterImpl : CategoryPresenter, BaseAppPresenterImpl<CategoryView>() {

    var mModelImpl: PodcastModelmpl = PodcastModelmpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {

        mModelImpl.getCategoryDataFromApiAndSaveToDatabase(onSuccess = {}, onError = {})

        mModelImpl.getCategoryDataList( onError = {})
            .observe(lifeCycleOwner, Observer {
                it?.let { mView?.displayCategoryList(it) }
            })
    }

    override fun onTapCategoryListItem() {}
    override fun onTapFindSomethingNew() {

    }

    override fun onTapReload() {

    }
}