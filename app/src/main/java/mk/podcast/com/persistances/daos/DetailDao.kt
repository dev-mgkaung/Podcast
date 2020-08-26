package mk.podcast.com.persistances.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mk.podcast.com.datas.vos.DetailVO

@Dao
interface DetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetailData(podcasts: DetailVO)

    @Query("select * from detail")
    fun getAllDetailData(): LiveData<DetailVO>

}