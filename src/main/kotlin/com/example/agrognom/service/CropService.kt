package com.example.agrognom.service

import com.example.agrognom.entities.Crop
import com.example.agrognom.repository.CropRepository
import org.springframework.stereotype.Service

@Service
class CropService (
    private val cropRepository: CropRepository
) {
    fun getCrops(): List<Crop> {
        return cropRepository.findAll()
    }

    fun getCropById(id: Long): Crop {
        return cropRepository.findById(id).get()
    }
}