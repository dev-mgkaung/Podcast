package mk.podcast.com

import android.app.Application
import mk.podcast.com.datas.models.impls.PodcastFirebaseDataModelImpl

class PodcastApp : Application()
{
    override fun onCreate() {
        super.onCreate()
        //   PodcastModelmpl.initDatabase(applicationContext)
        PodcastFirebaseDataModelImpl.initDatabase(applicationContext)
    }
}