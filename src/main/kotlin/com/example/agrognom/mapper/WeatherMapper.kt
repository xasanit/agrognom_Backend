package com.example.agrognom.mapper

import com.example.agrognom.dto.WeatherApiResponse
import com.example.agrognom.dto.WeatherResponse
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface WeatherMapper {

    @Mapping(source = "location.name", target = "location")
    @Mapping(source = "current.temp_c", target = "temp_c")
    @Mapping(source = "current.humidity", target = "humidity")
    @Mapping(source = "current.condition.text", target = "condition")
    @Mapping(source = "current.last_updated", target = "last_updated")
    fun toDto(weather: WeatherApiResponse): WeatherResponse
}
