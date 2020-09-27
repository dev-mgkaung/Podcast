package mk.podcast.com.persistances.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mk.podcast.com.datas.vos.DetailEpisodeVO

@Dao
interface DetailDao {

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertDetailData(data: DetailEpisodeVO)
//
//    @Query("select * from detail WHERE id = :detail_id")
//    fun getAllDetailDataByEpisodeID(detail_id : String): LiveData<DetailEpisodeVO>

}