package com.example.agrognom.controllers

import com.example.agrognom.entities.Crop
import com.example.agrognom.service.CropService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/crop")
class CropController (
    private val cropService: CropService
) {
    @GetMapping
    fun getCrops(): List<Crop> {
        return cropService.getCrops()
    }

    @GetMapping("/{id}")
    fun getCrop(@PathVariable id: Long): Crop {
        return cropService.getCropById(id)
    }
}