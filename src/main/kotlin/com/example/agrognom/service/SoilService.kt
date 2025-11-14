package com.example.agrognom.service

import com.example.agrognom.entities.Soil
import com.example.agrognom.repository.SoilRepository
import org.springframework.stereotype.Service

@Service
class SoilService (
    private val soilRepository: SoilRepository
) {
    fun getSoils(): List<Soil> {
        return soilRepository.findAll()
    }

    fun getSoilById(id: Long): Soil {
        return  soilRepository.findById(id).get()
    }
}