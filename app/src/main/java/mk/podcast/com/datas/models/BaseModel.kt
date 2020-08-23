package mk.podcast.com.datas.models

import android.content.Context
import mk.podcast.com.BuildConfig
import mk.podcast.com.networks.PodcastApi
import mk.podcast.com.persistances.PodcastDatabase
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel  {

    protected var mApi: PodcastApi
    protected lateinit var mTheDB: PodcastDatabase


    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL_FIELD)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(mOkHttpClient)
            .build()

        mApi = retrofit.create(PodcastApi::class.java)
    }


    fun initDatabase(context: Context) {
        mTheDB = PodcastDatabase.getDBInstance(context)
    }

}