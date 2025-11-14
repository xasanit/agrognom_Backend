package com.example.agrognom.repository

import com.example.agrognom.entities.Soil
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SoilRepository: JpaRepository<Soil, Long>