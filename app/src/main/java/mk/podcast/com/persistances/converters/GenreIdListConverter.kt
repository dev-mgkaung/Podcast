package mk.podcast.com.persistances.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import mk.podcast.com.datas.vos.DataVO


class GenreIdListConverter {
    @TypeConverter
    fun toString(dataList: List<Int>):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toList(ListJsonStr:String): List<Int> {
        val dataListType = object : TypeToken<List<Int>>(){}.type
        return Gson().fromJson(ListJsonStr,dataListType)
    }
}