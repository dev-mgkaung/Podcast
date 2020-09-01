package mk.podcast.com.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import mk.podcast.com.R
import mk.padc.share.activities.BaseActivity

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