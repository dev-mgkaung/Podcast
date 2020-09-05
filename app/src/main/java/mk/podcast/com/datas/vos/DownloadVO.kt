package mk.podcast.com.datas.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "downloadtable")
data class DownloadVO(
       @PrimaryKey
       val donwload_podcast_title: String,
       val download_podcast_description : String,
       val download_podcast_url: String,
       val download_id : String,
)
{
//   @PrimaryKey(autoGenerate = true)
//   var download_id: Int = 0 // or foodId: Int? = null
}