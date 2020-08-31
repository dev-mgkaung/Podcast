package mk.podcast.com.persistances.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import mk.podcast.com.datas.vos.LookingFor

class LookingForConverter {
    @TypeConverter
    fun toString(dataList: LookingFor):String{
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toList(ListJsonStr:String): LookingFor {
        val dataListType = object : TypeToken<LookingFor>(){}.type
        return Gson().fromJson(ListJsonStr,dataListType)
    }
}