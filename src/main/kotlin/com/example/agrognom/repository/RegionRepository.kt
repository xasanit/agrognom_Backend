package com.example.agrognom.repository

import com.example.agrognom.entities.Region
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RegionRepository: JpaRepository<Region, Long>