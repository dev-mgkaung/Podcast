package mk.podcast.com.utils

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import mk.podcast.com.datas.vos.EpisodeVO

fun startDownloading(context: Context, data: EpisodeVO) {
    //download request
    val request = DownloadManager.Request(Uri.parse(data.audio))
        .apply {
            setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
            setTitle(data.title)
            setDescription(data.description)
            allowScanningByMediaScanner()
            setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            setDestinationInExternalPublicDir(
                Environment.DIRECTORY_DOWNLOADS, "${
                    data.title?.trim()?.substring(0, 8)
                }.mp3"
            )
        }
    //get download service , and enqueue file
    val manager= context?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
    manager.enqueue(request)
}