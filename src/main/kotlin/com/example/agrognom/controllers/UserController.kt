package com.example.agrognom.controllers

import com.example.agrognom.adapter.CustomUserDetails
import com.example.agrognom.dto.UserDto
import com.example.agrognom.extensions.user
import com.example.agrognom.service.UserService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController (
    private  val userService: UserService
) {
    @GetMapping
    fun getUser(@AuthenticationPrincipal userDetails: CustomUserDetails): UserDto {
        return userService.getUserDto(userDetails.user())
    }
}