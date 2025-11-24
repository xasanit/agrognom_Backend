package com.example.agrognom.dto

data class WeatherResponse(
    val location: String,
    val temp_c: Double,
    val humidity: Int,
    val condition: String,
    val last_updated: String,
)