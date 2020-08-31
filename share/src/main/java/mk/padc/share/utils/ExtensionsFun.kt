package mk.padc.share.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load( dataImageUrl : String)
{
    Glide.with(this)
            .load(dataImageUrl)
            .into(this)
}