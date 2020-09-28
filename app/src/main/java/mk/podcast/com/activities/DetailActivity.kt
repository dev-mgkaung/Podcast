package mk.podcast.com.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_scrolling.*
import mk.padc.share.utils.load
import mk.padc.share.utils.verifyAvailableNetwork
import mk.padc.themovie.utils.DOWNLOADPAGE
import mk.padc.themovie.utils.PLAYER_TYPE_FILE
import mk.padc.themovie.utils.PLAYER_TYPE_STREAMING
import mk.podcast.com.R
import mk.podcast.com.datas.vos.EpisodeVO
import mk.podcast.com.medias.MyMediaPlayerHelper
import mk.podcast.com.mvp.presenters.DetailPresenter
import mk.podcast.com.mvp.presenters.impls.DetailPresenterImpl
import mk.podcast.com.mvp.views.DetailView
import mk.podcast.com.views.viewpods.MiniMusicPlayerViewPod


class DetailActivity : AppCompatActivity(), DetailView {

    companion object {

        const val EPISODE_PARAM = "dataId"
        const val FROMPAGE = "fromPage"
        const val DOWNLOAD_AUDI_FILE_PATH = "audio_file_path"

        fun newIntent(
            context: Context,
            dataId: String,
            fromPage: String,
            assetFilePath: String?
        ): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EPISODE_PARAM, dataId)
            intent.putExtra(FROMPAGE, fromPage)
            intent.putExtra(DOWNLOAD_AUDI_FILE_PATH, assetFilePath)
            return intent
        }
    }

    private var initPlayer = false
    private lateinit var mPresenter: DetailPresenter
    private lateinit var mMiniMusicPlayerViewPod: MiniMusicPlayerViewPod

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setUpPresenter()
        setUpListener()
        setUpViewPod()
        mPresenter.onUiReady(this, intent.getStringExtra(EPISODE_PARAM).toString())
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpViewPod() {
        mMiniMusicPlayerViewPod = minimusicplayerviewpod as MiniMusicPlayerViewPod
        mMiniMusicPlayerViewPod.setDelegate(mPresenter)
    }

    @SuppressLint("SetTextI18n")
    override fun displayDetailData(data: EpisodeVO) {
        detail_title.text = data.title
        detail_description.text = Html.fromHtml(data.description)
        audio_time.text = "${data.audio_length_sec} sec"
        detail_image.load(data.thumbnail)
        mMiniMusicPlayerViewPod.setUpData(data.audio)

    }

    override fun onTouchPlayPauseIcon(audioUri: String) {
        if (intent.getStringExtra(FROMPAGE).toString() == DOWNLOADPAGE) {
            // If download fragment pass, no need to check internet connection
            mediaPlayerSetup(audioUri)
        } else {
            //if other fragment pass, need to check internet connection ,  this case to solve offline open player gerbage time data
            if (!verifyAvailableNetwork(this)) {
                Toast.makeText(this, "Please Check Internet Connection , This is streaming type", Toast.LENGTH_SHORT).show()
            } else {
                mediaPlayerSetup(audioUri)
            }
        }
    }

    fun mediaPlayerSetup(audioUri: String) {
        if (!initPlayer) {

            var type = PLAYER_TYPE_STREAMING
            var mAudioUrl = audioUri

            // If download fragment pass, media player require download audio filepath
            if (intent.getStringExtra(FROMPAGE).toString().equals(DOWNLOADPAGE)) {
                type = PLAYER_TYPE_FILE
                mAudioUrl = intent.getStringExtra(DOWNLOAD_AUDI_FILE_PATH).toString()
            }
            // First time media player initialization , fix duplicate player create case
            MyMediaPlayerHelper.initMediaPlayer(
                this, mAudioUrl,
                mMiniMusicPlayerViewPod.getSeekBar(),
                mMiniMusicPlayerViewPod.getPlayPauseImage(),
                mMiniMusicPlayerViewPod.getCurrentTimeLabel(),
                mMiniMusicPlayerViewPod.getTotalTimeLabel(), type
            )
            initPlayer = true
        } else {
            //  touch event player play pause toggle
            MyMediaPlayerHelper.playPauseMediaPlayBack(this)
        }
    }

    override fun onTouchForwardThirtySecIcon() {
        MyMediaPlayerHelper.forwardMediaPlayBack(this)
    }

    override fun onTouchBackwardFifteenSecIcon() {
        MyMediaPlayerHelper.backwardMediaPlayBack(this)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (initPlayer) MyMediaPlayerHelper.closeMediaPlayBack(this)
    }

    private fun setUpListener() {
        toolbar.setNavigationOnClickListener {
            if (initPlayer) MyMediaPlayerHelper.closeMediaPlayBack(this)
            super.onBackPressed()
        }
    }

    override fun showErrorMessage(error: String) {}
    override fun showLoading() {}
    override fun hideLoading() {}
}