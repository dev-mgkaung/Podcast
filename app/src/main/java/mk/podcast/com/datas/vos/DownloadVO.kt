package mk.podcast.com.datas.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName

@IgnoreExtraProperties
@Entity(tableName = "downloadtable")
data class DownloadVO(
       @PrimaryKey
       val download_id : String,
       val donwload_podcast_title: String,
       val download_podcast_description : String,
       val download_podcast_url: String,
       val download_audio_path : String,
)
{
//   @PrimaryKey(autoGenerate = true)
//   var download_id: Int = 0 // or foodId: Int? = null
}