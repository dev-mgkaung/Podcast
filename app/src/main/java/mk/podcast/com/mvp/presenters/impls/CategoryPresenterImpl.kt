package mk.podcast.com.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import mk.padc.share.mvp.presenters.impl.BaseAppPresenterImpl
import mk.podcast.com.datas.models.impls.PodcastFirebaseDataModelImpl
import mk.podcast.com.mvp.presenters.CategoryPresenter
import mk.podcast.com.mvp.views.CategoryView

class CategoryPresenterImpl : CategoryPresenter, BaseAppPresenterImpl<CategoryView>() {

    var mModelImpl: PodcastFirebaseDataModelImpl = PodcastFirebaseDataModelImpl

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {

        mModelImpl.getCategoryList(onSuccess = {
            mView?.displayCategoryList(it)
        }, onFailure = {})

    }

    override fun onTapCategoryListItem() {}
    override fun onTapFindSomethingNew() {}

    override fun onTapReload() {}
}