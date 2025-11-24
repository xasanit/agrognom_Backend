package com.example.agrognom.service

import com.example.agrognom.dto.WeatherResponse
import com.example.agrognom.entities.Field
import com.example.agrognom.entities.Recommendation
import com.example.agrognom.repository.RecommendationRepository
import org.springframework.stereotype.Service

@Service
class RecommendationService (
    private val recommendationApiService: RecommendationApiService,
    private val recommendationRepository: RecommendationRepository,
) {

    fun getRecommendation(field: Field, weather: WeatherResponse): String {

        val prompt = """
        Дай рекомендации по уходу за полем со следующими данными: 
        площадь: ${field.area} гектаров,
        культура: ${field.crop?.name},
        тип почвы: ${field.soil?.name},
        регион: ${field.region?.name}, Кыргызстан,
        погодные условия: температура ${weather.temp_c}, влажность воздуха: ${weather.humidity}, состояние погоды: ${weather.condition}
    """.trimIndent()

        val response = recommendationApiService.getRecommendations(prompt = prompt)

        val recommendation = Recommendation().apply {
            this.field = field
            this.text = response
        }

        recommendationRepository.save(recommendation)

        return response
    }
}