package com.example.agrognom.service

import com.example.agrognom.dto.GeminiResponse
import org.springframework.beans.factory.annotation.Value

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class RecommendationApiService(
    private val restTemplate: RestTemplate,
    @Value("\${gemini.apiKey}") private val apiKey: String,
    @Value("\${gemini.baseUrl}") private val baseUrl: String
) {

    fun getRecommendations(prompt: String): String {

        val headers = HttpHeaders().apply {
            contentType = MediaType.APPLICATION_JSON
            set("X-goog-api-key", apiKey)
        }

        val requestBody = mapOf(
            "contents" to listOf(
                mapOf("parts" to listOf(mapOf("text" to prompt)))
            )
        )

        val entity = HttpEntity(requestBody, headers)

        val response = restTemplate.exchange(
            baseUrl,
            HttpMethod.POST,
            entity,
            GeminiResponse::class.java
        )

        return response.body
            ?.candidates
            ?.firstOrNull()
            ?.content
            ?.parts
            ?.firstOrNull()
            ?.text
            ?: "Нет ответа от модели"
    }
}