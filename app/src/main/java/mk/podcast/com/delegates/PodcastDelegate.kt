package mk.podcast.com.delegates

import mk.podcast.com.datas.vos.DataVO
import mk.podcast.com.datas.vos.PlayListVO

interface PodcastDelegate {
    fun onTapPlayListItem(playListVO: PlayListVO)
    fun onDownloadPodcastItem(dataVO: DataVO)
}