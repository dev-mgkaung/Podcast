package mk.podcast.com.datas.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "genere")
data class GenreVO(
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @SerializedName("name")   val name: String,
    @SerializedName("parent_id")   val parent_id: Int
)