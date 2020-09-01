package mk.podcast.com.persistances.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mk.podcast.com.datas.vos.RandomPodcastVO

@Dao
interface RandomPodCastDao {
    @Query("SELECT * FROM randompodcast")
    fun getAllRandomPodCast(): LiveData<RandomPodcastVO>

    @Query("SELECT * FROM randompodcast WHERE id = :podCastId")
    fun getRandomPodCastById(podCastId: Int): LiveData<RandomPodcastVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRandomPodcast(podcasts: RandomPodcastVO)
}