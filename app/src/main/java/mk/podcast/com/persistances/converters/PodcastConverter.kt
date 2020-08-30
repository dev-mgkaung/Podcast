package mk.podcast.com.persistances.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import mk.podcast.com.datas.vos.PodcastVO


class PodcastConverter {
    @TypeConverter
    fun toString(dataList:ArrayList<PodcastVO>):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toCountryList(countryListJsonStr:String):ArrayList<PodcastVO>{
        val dataListType = object : TypeToken<ArrayList<PodcastVO>>(){}.type
        return Gson().fromJson(countryListJsonStr,dataListType)
    }
}