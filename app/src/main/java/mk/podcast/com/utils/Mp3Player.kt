package mk.podcast.com.utils

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri

object Mp3Player{
    private var mp: MediaPlayer?=null
    init {
        println("Singleton class invoked.")
    }
    fun initSetUpPlayer(context: Context, type : String,audioUrl: String)
    {
        if(mp==null) {
            mp = MediaPlayer()
           if(type.equals("streaming")) mp?.setAudioStreamType(AudioManager.STREAM_MUSIC)
            mp?.setDataSource(context, Uri.parse(audioUrl)) }
            mp?.prepare()
            //    mp?.seekTo(mediaPlayer!!.currentPosition)
            mp?.setOnCompletionListener {
                if (it.currentPosition != 0) {
                    it.seekTo(0)
                }
            }
        }

    fun playAudio(){
        mp?.start()
    }
    fun pauseAudio()
    {
        mp?.pause()
    }
    fun releaseAudio()
    {
        mp?.release()
    }
    fun resumeAudio()
    {

    }

}
