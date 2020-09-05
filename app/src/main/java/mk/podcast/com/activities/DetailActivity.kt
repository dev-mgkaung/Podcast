package mk.podcast.com.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_scrolling.*
import mk.padc.share.utils.load
import mk.padc.themovie.utils.DOWNLOADPAGE
import mk.padc.themovie.utils.PLAYER_TYPE_FILE
import mk.padc.themovie.utils.PLAYER_TYPE_STREAMING
import mk.podcast.com.R
import mk.podcast.com.datas.vos.DetailEpisodeVO
import mk.podcast.com.mvp.presenters.DetailPresenter
import mk.podcast.com.mvp.presenters.impls.DetailPresenterImpl
import mk.podcast.com.mvp.views.DetailView
import mk.podcast.com.medias.MyMediaPlayerHelper
import mk.podcast.com.views.viewpods.MiniMusicPlayerViewPod


class DetailActivity : AppCompatActivity(), DetailView {

    companion object {

        const val EPISODE_PARAM = "dataId"
        const val FROMPAGE ="fromPage"
        const val DOWNLOAD_AUDI_FILE_PATH ="audio_file_path"

        fun newIntent(context: Context, dataId: String, fromPage : String, assetFilePath : String): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EPISODE_PARAM, dataId)
            intent.putExtra(FROMPAGE, fromPage)
            intent.putExtra(DOWNLOAD_AUDI_FILE_PATH, assetFilePath)
            return intent
        }
    }
    private var initPlayer=true
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

    override fun displayDetailData(data: DetailEpisodeVO) {
        detail_title.text = data.title
        detail_description.text = Html.fromHtml(data.description)
        audio_time.text = "${data.audio_length_sec} sec"
        detail_image.load(data.thumbnail)
        mMiniMusicPlayerViewPod.setUpData(data.audio)
    }

    override fun onTouchPlayPauseIcon(audioUri: String) {

        if(initPlayer) {

               var type= PLAYER_TYPE_STREAMING
               var mAudioUrl = audioUri

            if( intent.getStringExtra(FROMPAGE).toString().equals(DOWNLOADPAGE))
            {
               type= PLAYER_TYPE_FILE
               mAudioUrl= intent.getStringExtra(DOWNLOAD_AUDI_FILE_PATH).toString()
              }

            MyMediaPlayerHelper.initMediaPlayer(
                this, mAudioUrl,
                mMiniMusicPlayerViewPod.getSeekBar(),
                mMiniMusicPlayerViewPod.getPlayPauseImage(),
                mMiniMusicPlayerViewPod.getCurrentTimeLabel(),
                mMiniMusicPlayerViewPod.getTotalTimeLabel(),
                type
            )
            initPlayer=false
        }else {
            MyMediaPlayerHelper.playPauseMediaPlayBack(this)
        }
    }

    override fun onTouchForwardThirtySecIcon() {
        MyMediaPlayerHelper.forwardMediaPlayBack(this)
    }

    override fun onTouchBackwardFifteenSecIcon() {
        MyMediaPlayerHelper.backwardMediaPlayBack(this)
    }

    private fun setUpListener() {
        toolbar.setNavigationOnClickListener {
            super.onBackPressed();
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        MyMediaPlayerHelper.closeMediaPlayBack(this)
    }

    override fun showErrorMessage(error: String) {}

    override fun showLoading() {}

    override fun hideLoading() {}
}