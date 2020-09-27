package mk.podcast.com.views.viewholders

import android.view.View
import kotlinx.android.synthetic.main.podcast_listitem.view.*
import mk.padc.share.utils.convertMillisecondToHMS
import mk.padc.share.utils.load
import mk.padc.share.views.viewholders.BaseViewHolder
import mk.podcast.com.datas.vos.PlayListVO
import mk.podcast.com.delegates.PodcastDelegate

class PodcastViewHolder(itemView: View, private val mDelegate: PodcastDelegate)
    : BaseViewHolder<PlayListVO>(itemView) {

    init {
        itemView.podcastlayout.setOnClickListener {
            mData?.let {
                mDelegate.onTapPlayListItem(it)
            }
        }
        itemView.download_img.setOnClickListener {
            mData?.let {
                it?.let {  mdata->   mDelegate.onTapDownloadPodcastItem(mdata.data) }
            }
        }
         }

    override fun bindData(data: PlayListVO) {
         mData = data
         mData?.data?.thumbnail?.let { itemView.podcast_img.load(it) }
       //  itemView.podcast_hour.text = mData?.data?.audio_length_sec?.toLong()?.convertMillisecondToHMS()
         itemView.description.text=mData?.data?.title
    }
}