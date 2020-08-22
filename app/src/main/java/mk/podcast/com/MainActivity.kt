package mk.podcast.com

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mk.podcast.com.activities.SplashActivity

class MainActivity : AppCompatActivity() {

    companion object {
        //MainActivity call from other screen
        fun newIntent(context: Context)=Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}