package com.example.agrognom.dto

data class AuthRequest(
    val username: String,
    val password: String,
    val email: String? = null
)

data class AuthResponse(val token: String)