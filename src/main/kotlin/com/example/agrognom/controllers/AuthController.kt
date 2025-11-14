package com.example.agrognom.controllers

import com.example.agrognom.dto.AuthRequest
import com.example.agrognom.dto.AuthResponse
import com.example.agrognom.service.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/auth")
class AuthController (
    private val authService: AuthService,
) {
    @PostMapping("/register")
    fun register(@RequestBody request: AuthRequest): ResponseEntity<AuthResponse> {

        val token = authService.register(request.username, request.password, request.email)
        return ResponseEntity.ok(AuthResponse(token))

    }

    @PostMapping("/login")
    fun login(@RequestBody request: AuthRequest): ResponseEntity<AuthResponse> {

        val token = authService.login(request.username, request.password)
        return ResponseEntity.ok(AuthResponse(token))

    }
}