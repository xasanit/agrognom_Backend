package com.example.agrognom.controllers

import com.example.agrognom.entities.Region
import com.example.agrognom.service.RegionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/regions")
class RegionController (
    private val regionService: RegionService
) {

    @GetMapping
    fun getRegions(): List<Region> {
        return regionService.getRegions()
    }

    @GetMapping("/{id}")
    fun getRegion(@PathVariable id: Long): Region {
        return regionService.getRegionById(id)
    }
}