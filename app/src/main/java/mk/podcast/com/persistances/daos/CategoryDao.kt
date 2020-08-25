package mk.podcast.com.persistances.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mk.podcast.com.datas.vos.CategoryVO
import mk.podcast.com.datas.vos.PodcastVO


@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategoryData(podcasts: CategoryVO)

    @Query("select * from category")
    fun getAllCategoryData(): LiveData<List<CategoryVO>>

}