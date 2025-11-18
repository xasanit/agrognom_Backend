package com.example.agrognom.controllers

import com.example.agrognom.dto.AuthRequest
import com.example.agrognom.dto.RefreshRequest
import com.example.agrognom.dto.TokenResponse
import com.example.agrognom.service.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authService: AuthService
) {

    @PostMapping("/register")
    fun register(@RequestBody request: AuthRequest): ResponseEntity<TokenResponse> {
        return ResponseEntity.ok(
            authService.register(request.username, request.password, request.email)
        )
    }

    @PostMapping("/login")
    fun login(@RequestBody request: AuthRequest): ResponseEntity<TokenResponse> {
        return ResponseEntity.ok(
            authService.login(request.username, request.password)
        )
    }

    @PostMapping("/refresh")
    fun refresh(@RequestBody request: RefreshRequest): ResponseEntity<TokenResponse> {
        return ResponseEntity.ok(
            authService.refresh(request.refreshToken)
        )
    }
}