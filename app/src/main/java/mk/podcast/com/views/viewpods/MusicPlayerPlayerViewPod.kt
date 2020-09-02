package mk.podcast.com.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.custom_meida_controller_layout.view.*
import kotlinx.android.synthetic.main.custom_music_playerview.view.*
import mk.padc.share.utils.load

class MusicPlayerPlayerViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var mDelegate: Delegate? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    fun setUpData(mtitle: String, mdesc: String,mimageUrl: String) {
        podcast_title.text= mtitle
        podcast_description.text=mdesc
        podcast_ImageView.load(mimageUrl)
    }

    fun setDelegate(delegate: Delegate) {
        mDelegate = delegate
    }

    private fun setUpListener() {
        thirtySecBtn.setOnClickListener { mDelegate?.onTouchThirtySec() }
        fifteenSecBtn.setOnClickListener { mDelegate?.onTouchFifteenSec() }
        playPauseBtn.setOnClickListener { mDelegate?.onTouchPlayPause() }
    }

    interface Delegate {
        fun onTouchPlayPause()
        fun onTouchFifteenSec()
        fun onTouchThirtySec()
    }

}