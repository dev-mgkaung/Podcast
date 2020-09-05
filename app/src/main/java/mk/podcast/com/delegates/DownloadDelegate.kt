package mk.podcast.com.delegates

import mk.podcast.com.datas.vos.DownloadVO

interface DownloadDelegate {
    fun onTapDownloadListItem(downloadVo: DownloadVO)
}