package mk.podcast.com.persistances.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mk.podcast.com.datas.vos.PodcastVO


@Dao
interface PodcastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPodcastData(podcasts: PodcastVO)

    @Query("select * from podcast")
    fun getAllPodcastData(): LiveData<List<PodcastVO>>

}