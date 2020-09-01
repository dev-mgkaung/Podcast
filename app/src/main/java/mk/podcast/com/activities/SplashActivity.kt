package mk.podcast.com.activities

import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import mk.padc.share.activities.BaseActivity
import mk.podcast.com.R

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //hiding title bar of this activity
        window.requestFeature(Window.FEATURE_NO_TITLE)
        //making this activity full screen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)

        //3 seconds splash time
        Handler().postDelayed({
            //start main activity
            startActivity(MainActivity.newIntent(this))
            //finish this activity
            finish()
        },2000)

    }
}