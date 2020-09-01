package mk.podcast.com.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.widget.Toast
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_scrolling.*
import mk.padc.share.utils.convertMillisecondToHMS
import mk.padc.share.utils.load
import mk.padc.themovie.utils.EPISODE_PARAM
import mk.podcast.com.R
import mk.podcast.com.datas.vos.DetailEpisodeVO
import mk.podcast.com.datas.vos.PodcastVO
import mk.podcast.com.mvp.presenters.DetailPresenter
import mk.podcast.com.mvp.presenters.impls.DetailPresenterImpl
import mk.podcast.com.mvp.views.DetailView

class DetailActivity : AppCompatActivity(), DetailView {

    companion object {
        fun newIntent(context: Context, episodeId: String) =
            Intent(context, DetailActivity::class.java)
                .apply {
                    putExtra(EPISODE_PARAM, episodeId)
                }
    }

    private lateinit var mPresenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var episodeId = intent.getStringExtra(EPISODE_PARAM)
        setUpPresenter()
        setUpListener()

        Toast.makeText(this,"Episode $episodeId", Toast.LENGTH_LONG).show()
        if (episodeId != null) {
            mPresenter.onUiReady(this, episodeId)
        }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun displayDetailData(data: DetailEpisodeVO) {
        detail_title.text=data.title
        detail_description.text= Html.fromHtml( data.description)
        audio_time.text= data.audio_length_sec.convertMillisecondToHMS()
        detail_image.load(data.thumbnail)
    }

    private fun setUpListener() {
        toolbar.setNavigationOnClickListener{
            super.onBackPressed();
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun showErrorMessage(error: String) {}

    override fun showLoading() {}

    override fun hideLoading() {}
}