package mk.podcast.com.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.*
import kotlinx.android.synthetic.main.custom_meida_controller_layout.view.*
import kotlinx.android.synthetic.main.custom_mini_music_playerview.view.*

class MiniMusicPlayerViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var mDelegate: Delegate? = null
    private lateinit var mAudioUri : String
    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }
    fun getPlayPauseImage() : ImageView{
        return playPauseBtn
    }
    fun getTotalTimeLabel() : TextView {
        return mini_total_time
    }
    fun getSeekBar() : SeekBar
    {
        return mini_seekbar
    }
    fun getCurrentTimeLabel() : TextView {
        return mini_current_time
    }

    fun setUpData(audioUrl: String) {
        mAudioUri=audioUrl
    }

    fun setDelegate(delegate: Delegate) {
        mDelegate = delegate
    }

    private fun setUpListener() {
        thirtySecBtn.setOnClickListener { mDelegate?.onTouchThirtySec() }
        fifteenSecBtn.setOnClickListener { mDelegate?.onTouchFifteenSec() }
        playPauseBtn.setOnClickListener { mDelegate?.onTouchPlayPause(mAudioUri) }
    }

    interface Delegate {
        fun onTouchPlayPause(mAudioUri: String)
        fun onTouchFifteenSec()
        fun onTouchThirtySec()
    }

}