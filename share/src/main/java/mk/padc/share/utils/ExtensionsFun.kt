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

    val hours : Long  = TimeUnit.MICROSECONDS.toHours(this)
    // long minutes = (milliseconds / 1000) / 60;
    val minutes = TimeUnit.MILLISECONDS.toMinutes(this)

    // long seconds = (milliseconds / 1000);
    val seconds = TimeUnit.MILLISECONDS.toSeconds(this)

    return  " $minutes m $seconds sec"
}

