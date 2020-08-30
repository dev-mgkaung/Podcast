package mk.podcast.com.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import mk.padc.share.adapters.BaseRecyclerAdapter
import mk.podcast.com.R
import mk.podcast.com.datas.vos.GenreVO
import mk.podcast.com.delegates.CategoryDelegate
import mk.podcast.com.views.viewholders.CategoryViewHolder

class CategoryRecyclerAdapter(private val mDelegate : CategoryDelegate) :
    BaseRecyclerAdapter<CategoryViewHolder, GenreVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_list_item,parent,false)
        return CategoryViewHolder(view, mDelegate)
    }
}