package mk.podcast.com.mvp.views

import mk.padc.share.mvp.views.BaseView
import mk.podcast.com.datas.vos.GenreVO

interface CategoryView : BaseView {
    fun displayCategoryList(list: List<GenreVO>)
    fun navigateToDetailScreen()
}