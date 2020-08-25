package mk.podcast.com.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import mk.padc.share.adapters.BaseRecyclerAdapter
import mk.podcast.com.R
import mk.podcast.com.datas.vos.PodcastVO
import mk.podcast.com.delegates.PodcastDelegate
import mk.podcast.com.views.viewholders.PodcastViewHolder

class PodcastRecyclerAdapter(private val mDelegate : PodcastDelegate) :
    BaseRecyclerAdapter<PodcastViewHolder, PodcastVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PodcastViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.podcast_listitem,parent,false)
        return PodcastViewHolder(view, mDelegate)
    }
}