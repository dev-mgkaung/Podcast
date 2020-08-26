package mk.podcast.com.persistances

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mk.padc.themovie.utils.DATABASE_NAME
import mk.podcast.com.datas.vos.CategoryVO
import mk.podcast.com.datas.vos.DetailVO
import mk.podcast.com.datas.vos.PodcastVO
import mk.podcast.com.persistances.daos.CategoryDao
import mk.podcast.com.persistances.daos.DetailDao
import mk.podcast.com.persistances.daos.PodcastDao

@Database(
    entities = [PodcastVO::class, CategoryVO::class, DetailVO::class],
    version = 3,
    exportSchema = false
)
abstract class PodcastDatabase : RoomDatabase() {
    companion object {

        var dbInstance: PodcastDatabase? = null

        fun getDBInstance(context: Context): PodcastDatabase {
            when (dbInstance) {
                null -> {
                    dbInstance =
                        Room.databaseBuilder(context, PodcastDatabase::class.java, DATABASE_NAME)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build()
                }
            }

            val i = dbInstance
            return i!!
        }
    }

    abstract fun podcastDao(): PodcastDao
    abstract fun catgoryDao(): CategoryDao
    abstract fun detailDao(): DetailDao
}