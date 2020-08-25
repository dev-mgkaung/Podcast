package mk.podcast.com.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import mk.padc.share.adapters.BaseRecyclerAdapter
import mk.podcast.com.R
import mk.podcast.com.datas.vos.PodcastVO
import mk.podcast.com.delegates.DownloadDelegate
import mk.podcast.com.views.viewholders.DownloadPodcastViewHolder

class DownloadRecyclerAdapter(private val mDelegate: DownloadDelegate) :
    BaseRecyclerAdapter<DownloadPodcastViewHolder, PodcastVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DownloadPodcastViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.download_podcast_listitem,parent,false)
        return DownloadPodcastViewHolder(view, mDelegate)
    }
}