package mk.podcast.com.datas.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
@Entity(tableName = "downloadtable")
data class DownloadVO(
    @PrimaryKey
    val download_id: Int,
    val donwload_podcast_title: String,
    val download_podcast_description: String,
    val download_podcast_url: String,
    val download_audio_path: String,
)