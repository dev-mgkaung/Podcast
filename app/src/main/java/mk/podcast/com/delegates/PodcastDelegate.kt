package mk.podcast.com.delegates

import mk.podcast.com.datas.vos.EpisodeVO


interface PodcastDelegate {
    fun onTapPlayListItem(episodeVO: EpisodeVO)
    fun onTapDownloadPodcastItem(episodeVO: EpisodeVO?)
}