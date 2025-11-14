package com.example.agrognom.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class WeatherConfig {

    @Value("\${weather.apiKey}")
    lateinit var apiKey: String

    @Value("\${weather.baseUrl}")
    lateinit var apiBaseUrl: String

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplateBuilder().build()
    }
}