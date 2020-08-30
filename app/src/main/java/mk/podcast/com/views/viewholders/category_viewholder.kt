package mk.podcast.com.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.category_list_item.view.*
import mk.padc.share.views.viewholders.BaseViewHolder
import mk.podcast.com.datas.vos.CategoryVO
import mk.podcast.com.datas.vos.PodcastVO
import mk.podcast.com.delegates.CategoryDelegate


class CategoryViewHolder(itemView: View, private val mDelegate: CategoryDelegate)
    : BaseViewHolder<CategoryVO>(itemView) {

    init {
        itemView.category_cardview.setOnClickListener {
            mData?.let {
                mDelegate.onTapCategoryListItem()
            }
        }
    }

    override fun bindData(data: CategoryVO) {
        mData = data
        //  itemView.progressBar.
//        itemView.download_img
//        itemView.title
//        itemView.description
//        itemView.podcast_hour
    //    itemView.loadImageView(this,itemView.downloadimage,mData.imageurl)
    }

}