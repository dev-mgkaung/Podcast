package mk.podcast.com.medias

import android.app.Activity
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Handler
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import mk.podcast.com.R
import java.util.concurrent.TimeUnit


object MyMediaPlayerHelper
{

    init { }
    lateinit var mediaPlayer: MediaPlayer
    private lateinit var seekBar: SeekBar
    private var handler: Handler = Handler()
    private var onTime: Int = 0
    private var playTime: Int = 0
    private var endTime: Int = 0
    private var forwardTime: Int = 30000
    private var backwardTime: Int = 15000

    lateinit var  mPlaypauseImage: ImageView
    lateinit var  mCurrentTime : TextView
    lateinit var  mTotalTime : TextView
    lateinit var  mSeekBar: SeekBar

    fun initMediaPlayer(
        context: Activity,
        audioUri: String,
        seekBar: SeekBar,
        playpauseImage: ImageView,
        currentTime: TextView,
        totalTime: TextView
    ) {

        //View Binding
        mCurrentTime=currentTime
        mSeekBar=seekBar
        mPlaypauseImage=playpauseImage
        mTotalTime=totalTime

            //Media Player Setup
            mediaPlayer = MediaPlayer().apply {
                setAudioStreamType(AudioManager.STREAM_MUSIC)
                setAudioAttributes(
                    AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
                )
                setDataSource(audioUri)
                prepare()
            }

            // Seek bar change listener
            mSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                    if (b) {
                        mediaPlayer.seekTo(i * 1000)
                    }
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {}
                override fun onStopTrackingTouch(seekBar: SeekBar) {}
            })
        }

    private val updateSongTime = object : Runnable {
        override fun run() {
            playTime = mediaPlayer.currentPosition
            mCurrentTime.text =String.format(
                "%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes(playTime.toLong()),
                (TimeUnit.MILLISECONDS.toSeconds(playTime.toLong()) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(playTime.toLong()))))
            mSeekBar.progress = playTime
            handler.postDelayed(this, 100)
        }
    }


     fun forwardMediaPlayBack(context: Activity,)
    {
        if ((playTime + forwardTime) <= endTime) {
            playTime += forwardTime
            mediaPlayer.seekTo(playTime)
        } else {
            Toast.makeText(context, "Cannot jump forward 30 seconds", Toast.LENGTH_SHORT).show()
        }
    }

    fun playPauseMediaPlayBack(context: Activity)
    {
        if(mediaPlayer.isPlaying())
        {
            mediaPlayer.pause()
            mPlaypauseImage.setImageResource(R.drawable.ic_baseline_play_circle_filled_24)
        }else
        {
            mediaPlayer.start()
            mediaPlayer.seekTo(mediaPlayer.currentPosition)
            mPlaypauseImage.setImageResource(R.drawable.ic_baseline_pause_circle_filled_24)
            endTime = mediaPlayer.duration
            playTime = mediaPlayer.currentPosition
            mSeekBar.max = endTime
            onTime = 1
            mSeekBar.progress = playTime
            handler.postDelayed(updateSongTime, 100)
        }

        mTotalTime.text = String.format(
            "%d min, %d sec",
            TimeUnit.MILLISECONDS.toMinutes(endTime.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(endTime.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(endTime.toLong())
            )
        )
        mCurrentTime.text = String.format(
            "%d min, %d sec",
            TimeUnit.MILLISECONDS.toMinutes(playTime.toLong()),
            TimeUnit.MILLISECONDS.toSeconds(playTime.toLong()) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(playTime.toLong())
            )
        )
    }
    fun  closeMediaPlayBack(context: Activity)
    {

        handler.removeCallbacksAndMessages(null)
        mediaPlayer.release()
    }

     fun backwardMediaPlayBack(context: Activity,)
    {
        if ((playTime - backwardTime) > 0) {
            playTime -= backwardTime
            mediaPlayer.seekTo(playTime)
        } else {
            Toast.makeText(context, "Cannot jump backward 15 seconds", Toast.LENGTH_SHORT).show()
        }
    }
}