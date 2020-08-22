package mk.padc.share.mvp.presenters
import mk.padc.share.mvp.views.BaseView

interface BasePresenter<T : BaseView> {
    fun initPresenter(view: T)
}