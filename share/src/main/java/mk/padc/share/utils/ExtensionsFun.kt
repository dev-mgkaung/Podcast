package mk.padc.share.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import mk.padc.share.R

fun ImageView.load(dataImageUrl: String?) {
    Glide.with(this)
        .load(dataImageUrl)
        .into(this)
}

fun randomNumber(start: Int, end: Int): Int {
    require(start <= end) { "Illegal Argument" }
    return (start..end).random()
}


fun Long.convertMillisecondToHMS(): String {

    val minutes = this / 1000 / 60
    val seconds = this / 1000 % 60

    return "$minutes min $seconds sec"
}


