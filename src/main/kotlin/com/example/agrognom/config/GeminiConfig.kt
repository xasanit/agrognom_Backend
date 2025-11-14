package com.example.agrognom.config

import com.google.genai.Client
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GeminiConfig {

    @Value("\${gemini.apiKey}")
    lateinit var apiKey: String

    @Bean
    fun geminiClient(): Client {
        return Client.builder()
            .apiKey(apiKey)
            .build()
    }
}