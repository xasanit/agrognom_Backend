package com.example.agrognom.mapper

import com.example.agrognom.dto.UserDto
import com.example.agrognom.dto.WeatherApiResponse
import com.example.agrognom.dto.WeatherResponse
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface WeatherMapper {
    fun toDto(weather: WeatherApiResponse): WeatherResponse
}