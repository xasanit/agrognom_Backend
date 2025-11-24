package com.example.agrognom.controllers

import com.example.agrognom.dto.WeatherApiResponse
import com.example.agrognom.service.WeatherApiService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/weather")
class WeatherController (
    private val weatherApiService: WeatherApiService
) {

    @GetMapping("/{regionId}")
    fun getWeather(
        @PathVariable regionId: Long
    ): WeatherApiResponse {

        return weatherApiService.getWeather(regionId)

    }
}