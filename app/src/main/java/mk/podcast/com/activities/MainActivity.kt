package mk.podcast.com.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import mk.podcast.com.R
import androidx.navigation.ui.AppBarConfiguration
import mk.padc.share.activities.BaseActivity
import mk.podcast.com.adapters.PodcastRecyclerAdapter
import mk.podcast.com.datas.vos.PodcastVO
import mk.podcast.com.mvp.presenters.MainPresenter
import mk.podcast.com.mvp.views.MainView

class MainActivity :  BaseActivity()  {

    companion object {
        //MainActivity call from other screen
        fun newIntent(context: Context)=Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        navView.setupWithNavController(navController)
    }

}