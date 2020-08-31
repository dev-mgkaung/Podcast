package mk.podcast.com.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_pod_empty.view.*

class EmptyViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var mDelegate: Delegate? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    fun setEmptyData(emptyMessage: String, emptyImageUrl: String) {}

    fun setDelegate(delegate: Delegate) {
        mDelegate = delegate
    }

    private fun setUpListener() {
        btnFind.setOnClickListener {
            mDelegate?.onTapFindSomethingNew()
        }
        btnReload.setOnClickListener {
            mDelegate?.onTapReload()
        }
    }

    interface Delegate {
        fun onTapFindSomethingNew()
        fun onTapReload()
    }

}