package mk.podcast.com.persistances

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mk.padc.themovie.utils.DATABASE_NAME
import mk.podcast.com.datas.vos.*
import mk.podcast.com.persistances.daos.*

@Database(
    entities = [GenreVO::class, DownloadVO::class],
    version = 5,
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
    abstract fun generDao(): GenerDao
    abstract fun detailDao(): DetailDao
    abstract fun playListDao(): PlayListDao
    abstract fun randomPodCastDao(): RandomPodCastDao
    abstract fun downloadDao() : DownloadDao
}