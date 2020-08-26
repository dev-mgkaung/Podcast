package mk.podcast.com.datas.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "detail")
data class DetailVO(
    @PrimaryKey
    @SerializedName("id") var id: Int=0,
    @SerializedName("title") var title: String="",
    @SerializedName("description") var description: String="",
    @SerializedName("hour") var hour: String="",
    @SerializedName("count") var count: String="",
    @SerializedName("message") var message: String="",
)