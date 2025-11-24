package com.example.agrognom.dto

data class WeatherApiResponse(
    val location: Location,
    val current: Current,
)

data class Location(
    val name: String,
)

data class Current(
    val temp_c: Double,
    val humidity: Int,
    val condition: Condition,
    val last_updated: String,
)

data class Condition(
    val text: String,
)