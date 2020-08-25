package mk.podcast.com.views.viewpods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.bumptech.glide.Glide

class EmptyViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var mDelegate: Delegate? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    fun setEmptyData(emptyMessage: String, emptyImageUrl: String) {
       // tvEmpty.text = emptyMessage

//        Glide.with(context)
//            .load(emptyImageUrl)
//            .into(ivEmptyImage)
    }

    fun setDelegate(delegate: Delegate) {
        mDelegate = delegate
    }

    private fun setUpListener() {
//        btnTryAgain.setOnClickListener {
//            mDelegate?.onTapTryAgain()
//        }
    }

    interface Delegate {
        fun onTapTryAgain()
        fun onTapReload()
    }

}