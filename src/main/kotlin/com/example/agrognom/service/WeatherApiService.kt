package com.example.agrognom.service

import com.example.agrognom.config.WeatherConfig
import com.example.agrognom.dto.WeatherApiResponse
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class WeatherApiService(
    private val weatherConfig: WeatherConfig,
    private val restTemplate: RestTemplate,
    private val regionService: RegionService
) {
    fun getWeather(regionId: Long): WeatherApiResponse {

        val coordinates = regionService.getRegionById(regionId).coordinates

        val url = "${weatherConfig.apiBaseUrl}?key=${weatherConfig.apiKey}&q=${coordinates?:"Bishkek"}&aqi=no"

        val response = restTemplate.getForObject(url, WeatherApiResponse::class.java) ?: error("Could not get weather response")

        return response
    }
}