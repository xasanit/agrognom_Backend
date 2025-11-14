package com.example.agrognom.repository

import com.example.agrognom.entities.Crop
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CropRepository: JpaRepository<Crop, Long>