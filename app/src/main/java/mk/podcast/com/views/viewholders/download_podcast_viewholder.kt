package mk.podcast.com.views.viewholders

import android.text.Html
import kotlinx.android.synthetic.main.download_podcast_listitem.view.*

import android.view.View
import mk.padc.share.utils.load
import mk.padc.share.views.viewholders.BaseViewHolder
import mk.podcast.com.datas.vos.DownloadVO
import mk.podcast.com.delegates.DownloadDelegate

class DownloadPodcastViewHolder(itemView: View, private val mDelegate: DownloadDelegate)
    : BaseViewHolder<DownloadVO>(itemView) {

    init {
        itemView.download_podcast_list_item.setOnClickListener {
            mData?.let {
                mDelegate.onTapDownloadListItem(it)
            }
        }
    }

    override fun bindData(data: DownloadVO) {
        mData = data
        itemView.download_podcast_img.load(dataImageUrl = data.download_podcast_url)
        itemView.download_title.text= data.donwload_podcast_title
        itemView.download_description.text = Html.fromHtml(data.download_podcast_description)
    }
}