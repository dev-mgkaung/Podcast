package mk.podcast.com.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import mk.podcast.com.R
import mk.podcast.com.datas.vos.PodcastVO
import mk.podcast.com.mvp.views.DetailView

class DetailActivity : AppCompatActivity(), DetailView {

    companion object {
        fun newIntent(context: Context)= Intent(context, DetailActivity::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

    }

    override fun displayData(list: List<PodcastVO>) {}
    override fun showErrorMessage(error: String) {

    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }
}