package mk.podcast.com.persistances.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mk.podcast.com.datas.vos.PlayListVO


@Dao
interface PlayListDao {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertPlayListData(data: List<PlayListVO>)
//
//    @Query("select * from playlist")
//    fun getAllPlayListData(): LiveData<List<PlayListVO>>

}