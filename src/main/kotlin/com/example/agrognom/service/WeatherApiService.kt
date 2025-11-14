package com.example.agrognom.service

import com.example.agrognom.config.WeatherConfig
import com.example.agrognom.dto.WeatherResponse
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class WeatherApiService(
    private val weatherConfig: WeatherConfig,
    private val restTemplate: RestTemplate,
    private val regionService: RegionService
) {
    fun getWeather(regionId: Long): WeatherResponse {

        val coordinates = regionService.getRegionById(regionId).coordinates

        val url = "${weatherConfig.apiBaseUrl}?key=${weatherConfig.apiKey}&q=${coordinates?:"Bishkek"}&aqi=no"

        val response = restTemplate.getForObject(url, WeatherResponse::class.java) ?: error("Could not get weather response")

        return response
    }
}