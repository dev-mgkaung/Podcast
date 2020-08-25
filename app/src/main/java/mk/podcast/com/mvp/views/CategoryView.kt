package mk.podcast.com.mvp.views

import mk.padc.share.mvp.views.BaseView
import mk.podcast.com.datas.vos.CategoryVO

interface CategoryView : BaseView {
    fun displayCategoryList(list: List<CategoryVO>)
    fun navigateToDetailScreen()
}