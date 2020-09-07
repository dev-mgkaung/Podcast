package mk.podcast.com.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.exoplayer2.DefaultLoadControl
import com.google.android.exoplayer2.DefaultRenderersFactory
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.PlayerControlView
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import kotlinx.android.synthetic.main.app_content_scrolling.*
import kotlinx.android.synthetic.main.fragment_profile.*
import mk.padc.themovie.utils.USER_AGENT
import mk.podcast.com.R
import mk.podcast.com.views.viewpods.EmptyViewPod

class ProfileFragment : Fragment() {

    private var playWhenReady = false
    private var currentWindow = 0
    private var playbackPosition: Long = 0
    private lateinit var player: SimpleExoPlayer
    private lateinit var mplayerview : PlayerControlView
    private  var audioUrl= "https://www.listennotes.com/e/p/50d0110bec79414eac61cb472c3c1de2/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mplayerview = playerview as PlayerControlView
        initPlayer()
    }

    fun initPlayer()
    {
        val trackSelector = DefaultTrackSelector()
        val loadControl = DefaultLoadControl()
        val renderersFactory = DefaultRenderersFactory(activity as Context)
        player = ExoPlayerFactory.newSimpleInstance(activity as Context, renderersFactory, trackSelector, loadControl)
        play(audioUrl)
    }

     fun play(url: String) {
         mplayerview.setPlayer(player)
        //1
        val userAgent = USER_AGENT
        //2
        val mediaSource = ExtractorMediaSource
            .Factory(DefaultDataSourceFactory(context, userAgent))
            .setExtractorsFactory(DefaultExtractorsFactory())
            .createMediaSource(Uri.parse(url))
        //3
        player.prepare(mediaSource)
        //4
         player.playWhenReady = true
    }

    override fun onDestroy() {
        super.onDestroy()
        releasePlayer()
    }

     fun releasePlayer() {
        player.stop()
        player.release()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {}
    }
}