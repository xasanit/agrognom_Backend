package com.example.agrognom.dto

import java.math.BigDecimal

data class FieldDto (
    val id: Long,
    val userId: Long,
    val name: String,
    val area: BigDecimal,
    val cropId: Long,
    val soilId: Long,
    val regionId: Long,
)