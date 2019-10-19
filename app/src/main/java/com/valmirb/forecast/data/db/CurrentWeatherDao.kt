package com.valmirb.forecast.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.valmirb.forecast.data.db.entity.CURRENT_WEATHER_ID
import com.valmirb.forecast.data.db.entity.CurrentWeatherEntry


@Dao
interface CurrentWeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weatherEntry: CurrentWeatherEntry)


    @Query("select * from currentWeather where id == $CURRENT_WEATHER_ID")
    fun getWeatherEntry() : LiveData<CurrentWeatherEntry>
}