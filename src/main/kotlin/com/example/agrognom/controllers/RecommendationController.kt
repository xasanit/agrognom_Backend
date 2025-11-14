package com.example.agrognom.controllers

import com.example.agrognom.service.FieldService
import com.example.agrognom.service.RecommendationService
import com.example.agrognom.service.WeatherApiService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/recommendation")
class RecommendationController (
    private val recommendationService: RecommendationService,
    private val fieldService: FieldService,
    private val weatherApiService: WeatherApiService
) {

    @GetMapping("/{fieldId}")
    fun getRecommendation(
        @PathVariable fieldId: Long,
    ): String {

        val field = fieldService.findById(fieldId)

        val weather = weatherApiService.getWeather(
            field.region?.id ?: throw RuntimeException("Region not set for this field")
        )

        return recommendationService.getRecommendation(field, weather)
    }
}