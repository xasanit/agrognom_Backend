package com.example.agrognom.dto

import java.math.BigDecimal

data class FieldCreateDto(
    val name: String,
    val area: BigDecimal,
    val cropId: Long?,
    val soilId: Long?,
    val regionId: Long?
)