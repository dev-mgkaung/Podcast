package mk.podcast.com.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.custom_meida_controller_layout.view.*

class MiniMusicPlayerViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var mDelegate: Delegate? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    fun setUpData(a: String, b: String) {}

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