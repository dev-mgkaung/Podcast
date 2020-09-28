package mk.podcast.com.persistances.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mk.podcast.com.datas.vos.EpisodeVO
import mk.podcast.com.datas.vos.PodcastVO

@Dao
interface EpisodeDao {
    @Query("SELECT * FROM episodes")
    fun getAllEpisodes(): LiveData<List<EpisodeVO>>

    @Query("SELECT * FROM episodes WHERE id = :podCastId")
    fun getEpisodeById(podCastId: Int): LiveData<EpisodeVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllEpisodes(podcasts: List<EpisodeVO>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEpisode(podcasts: EpisodeVO)

    @Query("select * from episodes WHERE id = :detail_id")
    fun getAllDetailDataByEpisodeID(detail_id: String): LiveData<EpisodeVO>
}