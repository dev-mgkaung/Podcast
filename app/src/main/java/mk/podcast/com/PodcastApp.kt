package mk.podcast.com

import android.app.Application

class PodcastApp : Application()
{
    override fun onCreate() {
        super.onCreate()
       // PodcastModelmpl.initDatabase(applicationContext)
    }
}