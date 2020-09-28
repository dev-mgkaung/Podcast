package mk.podcast.com.datas.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
@Entity(tableName = "genere")
data class GenreVO(
    @PrimaryKey
    var id: Int? = 0,
    var name: String? = "",
    var parent_id: Int? = 0
)