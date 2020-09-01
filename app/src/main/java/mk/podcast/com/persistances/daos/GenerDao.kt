package mk.podcast.com.persistances.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mk.podcast.com.datas.vos.GenreVO


@Dao
interface GenerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGenerData(data: List<GenreVO>)

    @Query("select * from genere")
    fun getAllGenerData(): LiveData<List<GenreVO>>

}