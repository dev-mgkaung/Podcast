package mk.podcast.com.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.podcast_listitem.view.*
import mk.padc.share.views.viewholders.BaseViewHolder
import mk.podcast.com.datas.vos.PlayListVO
import mk.podcast.com.datas.vos.PodcastVO
import mk.podcast.com.delegates.PodcastDelegate

class PodcastViewHolder(itemView: View, private val mDelegate: PodcastDelegate)
    : BaseViewHolder<PlayListVO>(itemView) {

    init {
        itemView.podcastlayout.setOnClickListener {
            mData?.let {
                mDelegate.onTapPodCastListItem()
            }
        }
         }

    override fun bindData(data: PlayListVO) {
         mData = data
     //  itemView.progressBar.
//        itemView.download_img
//        itemView.title
//        itemView.description
//        itemView.podcast_hour
//        Glide.with(itemView.podcast_img)
//            .load(data.image)
//            .into(itemView.podcast_img)
    }
}