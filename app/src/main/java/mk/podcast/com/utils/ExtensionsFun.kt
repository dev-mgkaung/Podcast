package mk.podcast.com.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(context : Context, dataImage : ImageView, dataImageUrl : String)
{
    Glide.with(context)
            .load(dataImageUrl)
            .into(dataImage)
}