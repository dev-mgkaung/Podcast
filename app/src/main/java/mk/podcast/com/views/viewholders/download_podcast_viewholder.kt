package mk.podcast.com.views.viewholders

import kotlinx.android.synthetic.main.download_podcast_listitem.view.*

import android.view.View
import com.bumptech.glide.Glide
import mk.padc.share.views.viewholders.BaseViewHolder
import mk.podcast.com.datas.vos.PodcastVO
import mk.podcast.com.delegates.DownloadDelegate

class DownloadPodcastViewHolder(itemView: View, private val mDelegate: DownloadDelegate)
    : BaseViewHolder<PodcastVO>(itemView) {

    init {
        itemView.download_podcast_list_item.setOnClickListener {
            mData?.let {
                mDelegate.onTapDownloadListItem()
            }
        }
    }

    override fun bindData(data: PodcastVO) {
        mData = data
        //  itemView.progressBar.
//        itemView.download_img
//        itemView.title
//        itemView.description
//        itemView.podcast_hour
        Glide.with(itemView.download_podcast_img)
            .load(data.image)
            .into(itemView.download_podcast_img)
    }
}