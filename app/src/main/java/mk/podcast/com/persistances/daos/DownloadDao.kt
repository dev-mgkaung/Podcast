package mk.podcast.com.persistances.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mk.podcast.com.datas.vos.DownloadVO
import mk.podcast.com.datas.vos.PodcastVO

@Dao
interface DownloadDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDownloadPodcastData(podcasts: DownloadVO)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDownloadPodCastList(podCast: List<DownloadVO>)

    @Query("select * from downloadtable")
    fun getAllDownloadPodcastData(): LiveData<List<DownloadVO>>

}