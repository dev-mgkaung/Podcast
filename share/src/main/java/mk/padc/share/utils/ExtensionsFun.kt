package mk.padc.share.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import java.util.concurrent.TimeUnit
import kotlin.time.milliseconds

fun ImageView.load( dataImageUrl : String)
{
    Glide.with(this)
            .load(dataImageUrl)
            .into(this)
}

fun Long.convertMillisecondToHMS() : String{

    val minutes = this / 1000 / 60
    val seconds = this / 1000 % 60

    return "$minutes min $seconds sec"
}


