package com.example.agrognom.repository

import com.example.agrognom.entities.Recommendation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RecommendationRepository: JpaRepository<Recommendation, Long> {}