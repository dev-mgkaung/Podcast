package mk.padc.share.utils

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager

fun verifyAvailableNetwork(activity: Activity):Boolean{
    val connectivityManager=activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo=connectivityManager.activeNetworkInfo
    return  networkInfo!=null && networkInfo.isConnected
}