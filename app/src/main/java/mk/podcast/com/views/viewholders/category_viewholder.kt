package mk.podcast.com.views.viewholders

import android.view.View
import kotlinx.android.synthetic.main.category_list_item.view.*
import mk.padc.share.utils.load
import mk.padc.share.views.viewholders.BaseViewHolder
import mk.podcast.com.datas.vos.GenreVO
import mk.podcast.com.delegates.CategoryDelegate


class CategoryViewHolder(itemView: View, private val mDelegate: CategoryDelegate)
    : BaseViewHolder<GenreVO>(itemView) {

    init {
        itemView.category_cardview.setOnClickListener {
            mData?.let {
                mDelegate.onTapCategoryListItem()
            }
        }
    }

    override fun bindData(data: GenreVO) {
        mData = data
        itemView.cateogry_title.text=mData?.name
    }

}