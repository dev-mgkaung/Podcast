package mk.podcast.com.medias

import android.app.Activity
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.MediaPlayer.OnPreparedListener
import android.os.Environment
import android.os.Handler
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import mk.padc.themovie.utils.PLAYER_TYPE_STREAMING
import mk.podcast.com.R
import java.util.concurrent.TimeUnit


object MyMediaPlayerHelper
{

    //Variable
    lateinit var mediaPlayer: MediaPlayer
    private var handler: Handler = Handler()
    private var onTime: Int = 0
    private var playTime: Int = 0
    private var endTime: Int = 0
    private var forwardTime: Int = 30000
    private var backwardTime: Int = 15000

    // Android view
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
        totalTime: TextView,
        type: String
    ) {

        mCurrentTime=currentTime
        mSeekBar=seekBar
        mPlaypauseImage=playpauseImage
        mTotalTime=totalTime

            //Media Player create
            mediaPlayer = MediaPlayer().apply {
                         setAudioAttributes(
                         AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()) }
          mediaPlayer.setOnCompletionListener {
              mPlaypauseImage.setImageResource(R.drawable.ic_baseline_play_circle_filled_24)
          }

            try{
                 if(type == PLAYER_TYPE_STREAMING)
                    {
                       mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
                       mediaPlayer.setDataSource(audioUri)
                       mediaPlayer.prepareAsync()
                       mCurrentTime.text= "Loading.."
                    }
                 else{
                    mediaPlayer.setDataSource(Environment.getExternalStorageDirectory().absolutePath +"/Download/${audioUri}.mp3")
                    mediaPlayer.prepare()
                    }
             }catch (exception: Exception){}

            mediaPlayer.setOnPreparedListener(OnPreparedListener { playPauseMediaPlayBack(context) })

             // Seek bar change listener
            mSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    if (fromUser) {
                        try {
                            mediaPlayer.seekTo(progress)
                            }catch (e : Exception){}
                    }
                }
                override fun onStartTrackingTouch(seekBar: SeekBar) {}
                override fun onStopTrackingTouch(seekBar: SeekBar) {}
            })

        }

     var updateSongTime = object : Runnable {
        override fun run() {
            playTime = mediaPlayer.currentPosition
            mCurrentTime.text =String.format(
                "%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes(playTime.toLong()),
                     (TimeUnit.MILLISECONDS.toSeconds(playTime.toLong()) - TimeUnit.MINUTES.toSeconds(
                    TimeUnit.MILLISECONDS.toMinutes(playTime.toLong())))
            )
            mSeekBar.progress = playTime
            handler.postDelayed(this, 1000)
        }
    }

    fun mediaPlayerStopPlayBack(context: Activity)
    {
        mediaPlayer.stop()
    }
    
     fun forwardMediaPlayBack(context: Activity)
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
            mPlaypauseImage.setImageResource(R.drawable.ic_baseline_pause_circle_filled_24)
            endTime = mediaPlayer.duration
            playTime = mediaPlayer.currentPosition
            mSeekBar.max = endTime
            onTime = 1
            mSeekBar.progress = playTime
            handler.postDelayed(updateSongTime, 1000)

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

    }
    fun  closeMediaPlayBack(context: Activity)
    {
        handler.removeCallbacksAndMessages(null)
        mediaPlayer.release()
    }

     fun backwardMediaPlayBack(context: Activity)
    {
        if ((playTime - backwardTime) > 0) {
            playTime -= backwardTime
            mediaPlayer.seekTo(playTime)
        } else {
            Toast.makeText(context, "Cannot jump backward 15 seconds", Toast.LENGTH_SHORT).show()
        }
    }
}