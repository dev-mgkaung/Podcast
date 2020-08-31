package mk.padc.share.mvp.views

interface BaseView {
    fun showErrorMessage(error: String)
    fun showLoading()
    fun hideLoading()
}