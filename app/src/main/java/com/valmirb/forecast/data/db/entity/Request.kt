package com.valmirb.forecast.data.db.entity



data class Request(
    val type: String,
    val query: String,
    val language: String,
    val unit: String
)