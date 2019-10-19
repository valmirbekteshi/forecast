package com.valmirb.forecast.data.response

import com.google.gson.annotations.SerializedName
import com.valmirb.forecast.data.db.entity.CurrentWeatherEntry
import com.valmirb.forecast.data.db.entity.Location
import com.valmirb.forecast.data.db.entity.Request


data class CurrentWeatherResponse(
    val request: Request,
    val location: Location,
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry? = null
)