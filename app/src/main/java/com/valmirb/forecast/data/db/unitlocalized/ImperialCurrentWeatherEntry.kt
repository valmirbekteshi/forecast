package com.valmirb.forecast.data.db.unitlocalized

import androidx.room.ColumnInfo

class ImperialCurrentWeatherEntry (
    @ColumnInfo(name = "tempF")
    override val temperature: Double,
    override val conditionText: String,
    override val conditionIconUrl: String,
    override val windSpeed: Double,
    override val windDirection: String,
    override val precipitationVolume: Double,
    override val feelsLikeTemperature: Double,
    override val visibilityDistance: Double) : UnitSpecificCurrentWeatherEntry