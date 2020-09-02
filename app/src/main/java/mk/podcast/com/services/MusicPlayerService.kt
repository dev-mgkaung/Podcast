package mk.podcast.com.services

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import mk.podcast.com.utils.*
import java.util.*


class MusicPlayerService : Service() {

    private var mediaPlayer: MediaPlayer? = null
    var myUri = Uri.parse("https://dls.music-fa.com/tagdl/downloads/Aron%20Afshar%20-%20Gisoo%20Parishan%20(128).mp3")
    private var timer: Timer?=null

    override fun onCreate() {
        super.onCreate()
        val intentFilter = IntentFilter()
        intentFilter.addAction("mk.podcast.com.services.musiplayer")
        registerReceiver(broadcastReceiver, intentFilter)
        startMusic()
    }


    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        //mediaPlayer.start()
        return START_NOT_STICKY
    }


    override fun onDestroy() {
        super.onDestroy()

        mediaPlayer?.stop()
        timer?.cancel()
        unregisterReceiver(broadcastReceiver)
    }

    private fun startMusic() {
        mediaPlayer = MediaPlayer()
        mediaPlayer?.setAudioStreamType(AudioManager.STREAM_MUSIC)
        mediaPlayer?.setDataSource(this, myUri)
        mediaPlayer?.prepare()
        mediaPlayer?.seekTo(mediaPlayer!!.currentPosition)
        mediaPlayer?.setOnCompletionListener {
            if (it.currentPosition != 0) {
                it.seekTo(0)
            }

        }
    }

    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {
            if (p1!!.action == "tooka.io.services.music.player") {

                val state = p1.getIntExtra("STATE", 0)

                if (state == PLAY) {
                    if (mediaPlayer == null) {
                        startMusic()
                    }
                    mediaPlayer?.start()
                    startTimer()
                } else if (state ==  PAUSE) {
                    mediaPlayer?.pause()
                } else if (state == STOP) {
                    timer?.cancel()
                    if (mediaPlayer?.currentPosition != 0) {
                        mediaPlayer?.seekTo(0)
                    }

                    mediaPlayer?.stop()
                    mediaPlayer?.release()
                    mediaPlayer = null
                }else if (state== FORWARD){
                    val cPos=mediaPlayer?.currentPosition
                    mediaPlayer?.seekTo(cPos!!+5000)
                } else if (state == BACKWARD) {
                    val cPos = mediaPlayer?.currentPosition
                    mediaPlayer?.seekTo(cPos!! - 5000)
                }else if (state == SEEKCHANGE){
                    val seekPosition=p1.getIntExtra("SEEK_POSITION",0)
                    mediaPlayer?.seekTo(seekPosition)
                }


            }


        }
    }

    private fun sendDurationBroadcast(duration: Int=0, position: Int = 0) {
        val intent = Intent()
        intent.action = "mk.podcast.com.services"
        intent.putExtra("DURATION", duration)
        intent.putExtra("CURRENT_POSITION", position)
        sendBroadcast(intent)
    }

    private fun startTimer() {
        timer = Timer()
        timer?.schedule(MyTimerTask(), 0, 1000)
    }

    inner class MyTimerTask : TimerTask() {
        override fun run() {
            val duration = mediaPlayer?.duration
            val currentPosition = mediaPlayer?.currentPosition
            try {
                sendDurationBroadcast(duration!!, currentPosition!!)
            }catch (e:Exception){e.printStackTrace()}
        }

    }

}