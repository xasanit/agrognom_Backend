package com.example.agrognom.controllers

import com.example.agrognom.dto.WeatherResponse
import com.example.agrognom.entities.User
import com.example.agrognom.service.WeatherApiService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/weather")
class WeatherController (
    private val weatherApiService: WeatherApiService
) {
    @GetMapping
    fun getWeatherForBishkek(
        @AuthenticationPrincipal user: User,
    ): WeatherResponse {
        return weatherApiService.getWeather(1)
    }

    @GetMapping("/{regionId}")
    fun getWeather(
        @PathVariable regionId: Long
    ): WeatherResponse {

        return weatherApiService.getWeather(regionId)

    }
}