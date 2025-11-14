package com.example.agrognom.service

import com.example.agrognom.entities.Region
import com.example.agrognom.repository.RegionRepository
import org.springframework.stereotype.Service

@Service
class RegionService (
    private val regionRepository: RegionRepository
) {
    fun getRegions(): List<Region> {
        return regionRepository.findAll()
    }

    fun getRegionById(id: Long): Region {
        return regionRepository.findById(id).get()
    }
}