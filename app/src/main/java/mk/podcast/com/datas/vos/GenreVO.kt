package mk.podcast.com.datas.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName

@IgnoreExtraProperties
@Entity(tableName = "genere")
data class GenreVO(
     @PrimaryKey
     val id: Int? = 0,
     var name: String? = "",
     var image_url: String? = "",
     var parent_id: Int? = 0
)