package mk.podcast.com.views.viewpods

import android.content.Context
import android.text.Html
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.custom_meida_controller_layout.view.*
import kotlinx.android.synthetic.main.custom_music_playerview.view.*
import mk.padc.share.utils.load

class MusicPlayerPlayerViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var mDelegate: Delegate? = null
    private var mAudioUrl : String ?=null

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    fun setUpData(mtitle: String, mdesc: String,mimageUrl: String, maudioUrl : String) {
        podcast_title.text= mtitle
        podcast_description.text= Html.fromHtml(mdesc)
        podcast_ImageView.load(mimageUrl)
        mAudioUrl=maudioUrl
    }

    fun getPlayPauseImage() : ImageView{
        return playPauseBtn
    }
    fun getProgressBar() : ProgressBar
    {
        return progressBar2
    }
    fun getRemainingTime() : TextView{
        return remainingTime
    }

    fun setDelegate(delegate: Delegate) {
        mDelegate = delegate
    }

    private fun setUpListener() {
        thirtySecBtn.setOnClickListener { mDelegate?.onTouchThirtySec() }
        fifteenSecBtn.setOnClickListener { mDelegate?.onTouchFifteenSec() }
        playPauseBtn.setOnClickListener { mAudioUrl?.let { it1 -> mDelegate?.onTouchPlayPause(it1) } }
    }

    interface Delegate {
        fun onTouchPlayPause(audioUrl : String)
        fun onTouchFifteenSec()
        fun onTouchThirtySec()
    }

}