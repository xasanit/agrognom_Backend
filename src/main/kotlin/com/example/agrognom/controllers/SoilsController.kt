package com.example.agrognom.controllers

import com.example.agrognom.entities.Soil
import com.example.agrognom.service.SoilService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/soils")
class SoilsController (
    private val soilService: SoilService,
) {
    @GetMapping
    fun getSoils(): List<Soil> {
        return soilService.getSoils()
    }

    @GetMapping("/{id}")
    fun getSoilById(@PathVariable id: Long): Soil {
        return soilService.getSoilById(id)
    }
}